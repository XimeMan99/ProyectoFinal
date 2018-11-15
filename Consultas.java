/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import Clases.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Consultas {
    
    public static Alumno alumno_Loggeado;

    public static void ComboTipoAlumno(JComboBox<ComboBoxItem> combo_tipo) throws SQLException {
        Connection con = ConexionMySQL.conectarMySQL();
        Statement cmd = con.createStatement(); 
        ResultSet reader = cmd.executeQuery ("select * from tipo_alumno");
        
        while (reader.next()) 
        { 
            ComboBoxItem item = new ComboBoxItem();
            item.valor = (reader.getInt(1));
            item.text = (reader.getString(2));
            combo_tipo.addItem(item);
        }
    }
    
    public static ObjetoPerdido ObtenerObjeto(int cod_objeto) throws SQLException
    {
        ObjetoPerdido objeto = null;
        Connection con = ConexionMySQL.conectarMySQL();
        Statement cmd = con.createStatement(); 
        ResultSet reader = cmd.executeQuery ("select * from objeto_perdido where cod_objeto = "+cod_objeto);
        
        while (reader.next()) 
        { 
            objeto = new ObjetoPerdido();
            objeto.detalles = reader.getString("nombre");
            objeto.lugar = reader.getString("lugar");
            objeto.fecha = reader.getDate("fecha").toString();
            objeto.alumno_cod_alumno = reader.getInt("alumno_cod_alumno");
        }
        
        return objeto;
    }
    
    public static void SubirObjeto(ObjetoPerdido objeto) throws SQLException
    {
        try{
            Date date = Date.valueOf(objeto.fecha);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al convertir el tipo fecha\nintentelo de nuevo");
            return;
        }
        Connection con = ConexionMySQL.conectarMySQL();
        Statement cmd = con.createStatement(); 
        cmd.executeUpdate("INSERT INTO objeto_perdido(nombre, lugar, fecha, alumno_cod_alumno) VALUES"
                + "('"+objeto.detalles+"','"+objeto.lugar+"','"+objeto.fecha+"',0)" );
    }
    
    public static void MarcarLeido(EstadoDocumento estado)
    {
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            cmd.executeUpdate("update estado_documento set estado = 2 where documento_cod_documento = "+
                    estado.getDocumento_cod_documento()+" and alumno_cod_alumno = "+estado.getAlumno_cod_alumno());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static boolean RegistrarAlumno(Alumno alumno) {
       Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            cmd.executeUpdate("insert into alumno(nombre, carnet, facultad, correo, numero, tipo_alumno_cod_tipo, contraseña) "
                + "values('"+alumno.getNombre()+"','"+alumno.getCarnet()+"','"+alumno.getFacultad()+"', '"+alumno.getCorreo()+"',"
                        +alumno.getNumero()+","+alumno.getTipo_alumno_cod_tipo()+", '"+alumno.getContraseña()+"')");
        
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean Login(String carnet, String contraseña) {
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from alumno where carnet LIKE '"+carnet+"' and contraseña LIKE '"+contraseña+"'");

            while (reader.next()) 
            { 
                alumno_Loggeado = new Alumno();
                alumno_Loggeado.setCod_alumno(reader.getInt("cod_alumno"));
                alumno_Loggeado.setNombre(reader.getString("nombre"));
                alumno_Loggeado.setCarnet(reader.getString("carnet"));
                alumno_Loggeado.setContraseña(reader.getString("contraseña"));
                alumno_Loggeado.setTipo_alumno_cod_tipo(reader.getInt("tipo_alumno_cod_tipo"));
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public static boolean ExisteAlumno(Alumno alumno) {
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select cod_alumno from alumno where carnet LIKE '"+alumno.getCarnet()+"'");

            while (reader.next()) 
            { 
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public static boolean AuxTieneCurso(Alumno alumno) {
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from asignacion_curso_alumno where alumno_cod_alumno ="+alumno.getCod_alumno());
            //System.out.println("select * from asignacion_curso_alumno where alumno_cod_alumno ="+alumno.getCod_alumno());
            while (reader.next()) 
            { 
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public static void ComboCursos(JComboBox<ComboBoxItem> combo_curso) throws SQLException {
        Connection con = ConexionMySQL.conectarMySQL();
        Statement cmd = con.createStatement(); 
        ResultSet reader = cmd.executeQuery ("select * from curso");
        
        while (reader.next()) 
        { 
            ComboBoxItem item = new ComboBoxItem();
            item.valor = (reader.getInt("cod_curso"));
            item.text = (reader.getString("nombre"));
            combo_curso.addItem(item);
        }
    }

    public static boolean AsignarCursoAuxiliar(Alumno alumno, int cod_curso) {
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            cmd.executeUpdate("insert into asignacion_curso_alumno (curso_cod_curso,alumno_cod_alumno) values ("+cod_curso+","+alumno.getCod_alumno()+")");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public static boolean EstudianteTieneCurso(Alumno alumno, int cod_curso)
    {
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from asignacion_curso_alumno where alumno_cod_alumno ="+alumno.getCod_alumno()+" and curso_cod_curso = "+cod_curso);
            //System.out.println("select * from asignacion_curso_alumno where alumno_cod_alumno ="+alumno.getCod_alumno());
            while (reader.next()) 
            { 
                return true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }
    
    public static boolean AsignarCursoEstudiante(Alumno alumno, int cod_curso) {
        
        if(EstudianteTieneCurso(alumno,cod_curso))
        {
            JOptionPane.showMessageDialog(null, "Ya tiene asignado este curso, intentelo de nuevo");
            return false;
        }
        
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            cmd.executeUpdate("insert into asignacion_curso_alumno (curso_cod_curso,alumno_cod_alumno) values ("+cod_curso+","+alumno.getCod_alumno()+")");
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static void EnviarDocumento(String documento) {
        Curso curso = ObtenerCursoAux(alumno_Loggeado);
        
        //INSERTO EN DOCUMENTO EL DOCUMENTO
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            cmd.executeUpdate("insert into documento (documento,curso_cod_curso) values ('"+documento+"',"+curso.getCod_curso()+")");
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        //OBTENGO EL ULTIMO DOCUMENTO INSERTADO
        int cod_documento = 0;
        con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery("SELECT MAX(cod_documento) FROM documento");
            while(reader.next())
            {
                cod_documento = reader.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        //OBTENGO LISTA DE ESTUDIANTES QUE LLEVAN EL CURSO QUE NO SEAN AUXILIARES
        ArrayList<Alumno> alumnos = ObtenerAlumnosDelCurso(curso);
        
        //INGRESO A LOS ESTADOS DE MENSAJES
        for (Alumno alumno : alumnos) 
        {
            con = ConexionMySQL.conectarMySQL();
            try {
                Statement cmd = con.createStatement(); 
                cmd.executeUpdate("insert into estado_documento (documento_cod_documento,alumno_cod_alumno,estado) values ("+cod_documento+","+alumno.getCod_alumno()+",1)");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public static Curso ObtenerCursoAux(Alumno alumno)
    {
        Curso curso = new Curso();
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery("select curso_cod_curso from asignacion_curso_alumno where alumno_cod_alumno = "+alumno.getCod_alumno());
            while(reader.next())
            {
                curso = ObtenerCurso(reader.getInt("curso_cod_curso"));
                return curso;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return curso;
    }
    
    public static ArrayList<Documento> ObtenerDocumentosDelCurso(Curso curso)
    {
        ArrayList<Documento> documentos = new ArrayList<>();
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery("select * from documento where curso_cod_curso = "+curso.getCod_curso());
            while(reader.next())
            {
                Documento doc = new Documento();
                doc.setCod_documento(reader.getInt("cod_documento"));
                doc.setCod_curso(curso.getCod_curso());
                doc.setDocumento(reader.getString("documento"));
                documentos.add(doc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return documentos;
    }
    
    public static ArrayList<EstadoDocumento> ObtenerEstadosDelAux(Alumno alumno)
    {
        ArrayList<EstadoDocumento> estados = new ArrayList<>();
        Curso curso = ObtenerCursoAux(alumno);
        ArrayList<Documento> documentos = ObtenerDocumentosDelCurso(curso);
        for (Documento documento : documentos) {
            try {
                Connection con = ConexionMySQL.conectarMySQL();
                Statement cmd = con.createStatement(); 
                ResultSet reader = cmd.executeQuery("select * from estado_documento where documento_cod_documento = "+documento.getCod_documento());
                while(reader.next())
                {
                    EstadoDocumento estado = new EstadoDocumento();
                    estado.setDocumento_cod_documento(reader.getInt("documento_cod_documento"));
                    estado.setAlumno_cod_alumno(reader.getInt("alumno_cod_alumno"));
                    estado.setEstado(reader.getInt("estado"));
                    estados.add(estado);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
            
        return estados;
    }
    
    public static ArrayList<EstadoDocumento> ObtenerEstadosDelAlumno(Alumno alumno)
    {
        ArrayList<EstadoDocumento> estados = new ArrayList<>();
            try {
                Connection con = ConexionMySQL.conectarMySQL();
                Statement cmd = con.createStatement(); 
                ResultSet reader = cmd.executeQuery("select * from estado_documento where alumno_cod_alumno = "+alumno.getCod_alumno());
                while(reader.next())
                {
                    EstadoDocumento estado = new EstadoDocumento();
                    estado.setDocumento_cod_documento(reader.getInt("documento_cod_documento"));
                    estado.setAlumno_cod_alumno(reader.getInt("alumno_cod_alumno"));
                    estado.setEstado(reader.getInt("estado"));
                    estados.add(estado);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        return estados;
    }
    
    public static ArrayList<Alumno> ObtenerAlumnosDelCurso(Curso curso)
    {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery("select * from asignacion_curso_alumno where curso_cod_curso = "+curso.getCod_curso());
            while(reader.next())
            {
                Alumno alumno = ObtenerAlumno(reader.getInt("alumno_cod_alumno")," and tipo_alumno_cod_tipo != 2"); //los que no son auxs
                if(alumno!=null)
                {
                    alumnos.add(alumno);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return alumnos;
    }
    
    public static Documento ObtenerDocumento(int cod_documento)
    {
        Documento documento = new Documento();
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery("select * from documento where cod_documento = "+cod_documento);
            while(reader.next())
            {
                documento.setCod_curso(reader.getInt("curso_cod_curso"));
                documento.setCod_documento(reader.getInt("cod_documento"));
                documento.setDocumento(reader.getString("documento"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return documento;
    }
    
    public static ArrayList<Curso> ObtenerCursosDelAlumno(Alumno alumno)
    {
        ArrayList<Curso> cursos = new ArrayList<>();
        
        Connection con = ConexionMySQL.conectarMySQL();
        try {
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery("select * from asignacion_curso_alumno where alumno_cod_alumno = "+alumno.getCod_alumno());
            while(reader.next())
            {
                Curso curso = ObtenerCurso(reader.getInt("curso_cod_curso"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return cursos;
    }
    
    public static Curso ObtenerCurso(int cod_curso)
    {
        Curso curso = new Curso();
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from curso where cod_curso ="+cod_curso);
            while (reader.next()) 
            { 
                curso.setCod_curso(reader.getInt("cod_curso"));
                curso.setNombre(reader.getString("nombre"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return curso;
    }
    
    public static Curso ObtenerCursoDelDocumento(int cod_documento)
    {
        Curso curso = new Curso();
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from documento where cod_documento ="+cod_documento);
            while (reader.next()) 
            { 
                curso = ObtenerCurso(reader.getInt("curso_cod_curso"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return curso;
    }
    
    public static Alumno ObtenerAlumno(int cod_alumno, String query)
    {
        Alumno alumno = null;
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from alumno where cod_alumno ="+cod_alumno +" "+ query);
            while (reader.next()) 
            { 
                alumno = new Alumno();
                alumno.setCod_alumno(reader.getInt("cod_alumno"));
                alumno.setNombre(reader.getString("nombre"));
                alumno.setCarnet(reader.getString("carnet"));
                alumno.setContraseña(reader.getString("contraseña"));
                alumno.setTipo_alumno_cod_tipo(reader.getInt("tipo_alumno_cod_tipo"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return alumno;
    }
    
    public static void MarcarReclamo(ObjetoPerdido objeto)
    {
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            cmd.executeUpdate("update objeto_perdido set alumno_cod_alumno = "+alumno_Loggeado.getCod_alumno() + " and "
                    + "cod_objeto ="+objeto.cod_objeto);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static ArrayList<ObjetoPerdido> ObtenerObjetosReclamados() {
        ArrayList<ObjetoPerdido> objetos = new ArrayList<>();
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from objeto_perdido where alumno_cod_alumno !=0");
            ObjetoPerdido objeto;
            while (reader.next()) 
            { 
                objeto = new ObjetoPerdido();
                objeto.cod_objeto = reader.getInt("cod_objeto");
                objeto.alumno_cod_alumno = reader.getInt("alumno_cod_alumno");
                objeto.detalles = reader.getString("nombre");
                objeto.fecha = reader.getDate("fecha").toString();
                objeto.lugar = reader.getString("lugar");
                objetos.add(objeto);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return objetos;
    }

    public static ArrayList<ObjetoPerdido> ObtenerObjetosNOReclamados() {
        ArrayList<ObjetoPerdido> objetos = new ArrayList<>();
        Connection con = ConexionMySQL.conectarMySQL();
        try{
            Statement cmd = con.createStatement(); 
            ResultSet reader = cmd.executeQuery ("select * from objeto_perdido where alumno_cod_alumno =0");
            ObjetoPerdido objeto;
            while (reader.next()) 
            { 
                objeto = new ObjetoPerdido();
                objeto.cod_objeto = reader.getInt("cod_objeto");
                objeto.alumno_cod_alumno = reader.getInt("alumno_cod_alumno");
                objeto.detalles = reader.getString("nombre");
                objeto.fecha = reader.getDate("fecha").toString();
                objeto.lugar = reader.getString("lugar");
                objetos.add(objeto);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return objetos;
    }
}
