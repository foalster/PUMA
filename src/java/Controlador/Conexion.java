package Controlador;

import Modelo.Calculadora;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Usuario;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class Conexion {
    
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String url = "jdbc:postgresql://localhost:5433/PUMA";
    private String user ="IS1";
    private String pass = "hola123";
    private String drive = "org.postgresql.Driver";
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //private PreparedStatement pst;
    //private Control ctrl;
    
    public Conexion(){
        try{
            Class.forName(drive);
            con = DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public void conectar() throws Exception{
        try{
            Class.forName(drive);
            con = DriverManager.getConnection(url,user,pass);
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public void desconectar() throws Exception{
        try{
            con.close();
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public static boolean validarEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
    
     public static boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public boolean iniciarSesion(String usuario, String password) throws Exception{
        try{
            ArrayList usuarios = new ArrayList();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO = '" + usuario + "' AND PASSWORD = '" + password + "'" );
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
                usuarios.add(u);
            }
            if(!usuarios.isEmpty())
                return true;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return false;
    }
            
            
    public ArrayList getUsuarios() throws Exception{
        ArrayList usuarios = new ArrayList();
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM USUARIO");
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setNombre(rs.getString(4));
                u.setApPat(rs.getString(5));
                u.setApMat(rs.getString(6));
                u.setFechaNac(rs.getString(7));
                u.setGenero(rs.getString(8));
                u.setEmail(rs.getString(9));
                usuarios.add(u);
            }
        }catch(Exception ex){
            System.out.println("Error al recuperar los datos de la entidad usuario "
                    + ex.getMessage());
        }
        return usuarios;
    }
    
     public LinkedList<Calculadora> getCalculadoras()
   {
      LinkedList<Calculadora> listaContactos=new LinkedList<Calculadora>();
      try {
         stmt = con.createStatement();
         rs = stmt.executeQuery("SELECT * FROM CALCULADORA");
         while (rs.next())
         {
            Calculadora contacto = new Calculadora();
            contacto.setId(rs.getInt("idcalculadora"));
            contacto.setMarca(rs.getString("marca"));
            contacto.setModelo(rs.getString("modelo"));
            contacto.setDisponible(rs.getBoolean("disponible"));
            listaContactos.add(contacto);
         }
         rs.close();
         stmt.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return listaContactos;
   }
    
    public boolean checarUsuario(String usuario, String email) throws Exception{
        try{
            ArrayList usuarios = new ArrayList();
            PreparedStatement pst = con.prepareStatement("SELECT USUARIO, EMAIL FROM USUARIO WHERE USUARIO = '" + usuario + "' OR EMAIL = '" + email + "'" );
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setUsuario(rs.getString(1));
                u.setEmail(rs.getString(2));
                usuarios.add(u);
            }
            if(usuarios.isEmpty())
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return true;
    }
    
    
    public boolean registrar(String usuario, String password, String nombre, String appat, String apmat, String fechanac, String genero, String email) throws Exception{
        try{
            ArrayList usuarios = new ArrayList();
            PreparedStatement pst = con.prepareStatement("INSERT INTO USUARIO (USUARIO, PASSWORD, NOMBRE, APPAT, APMAT, FECHANAC, GENERO, EMAIL) VALUES ('"+ usuario
                    + "', '" + password + "', '" +nombre + "', '" + appat + "', '" + apmat + "', '" + fechanac + "', '" + genero + "', '" + email + "')");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setUsuario(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setApPat(rs.getString(4));
                u.setApMat(rs.getString(5));
                u.setFechaNac(rs.getString(6));
                u.setGenero(rs.getString(7));
                u.setEmail(rs.getString(8));
                usuarios.add(u);
            }
            if(usuarios.isEmpty())
                return false;
        }catch(Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }
        return true;
    }
}