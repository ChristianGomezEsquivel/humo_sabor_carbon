package Connections;

import Entidades.Empleado;
import Entidades.Usuario;
import Entidades.Insumo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrudManager {

    private Connection connection;

    public CrudManager(Connection connection) {
        this.connection = connection;
    }

    // Métodos CRUD para la tabla EMPLEADO
    public void insertEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO EMPLEADO (E_CLAVE, E_NOMBRE, E_CARGO, E_FECHA_REG, E_EMAIL) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, empleado.getClave());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getCargo());
            preparedStatement.setDate(4, (java.sql.Date)empleado.getFechaRegistro());
            preparedStatement.setString(5, empleado.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmpleado(Empleado empleado) throws SQLException {
        String sql = "UPDATE EMPLEADO SET E_NOMBRE=?, E_CARGO=?, E_FECHA_REG=?, E_EMAIL=? WHERE E_CLAVE=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getCargo());
            preparedStatement.setDate(3, empleado.getFechaRegistro());
            preparedStatement.setString(4, empleado.getEmail());
            preparedStatement.setString(5, empleado.getClave());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteEmpleado(String clave) throws SQLException {
        String sql = "DELETE FROM EMPLEADO WHERE E_CLAVE=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, clave);
            preparedStatement.executeUpdate();
        }
    }

    public List<Empleado> getAllEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM EMPLEADO";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setClave(resultSet.getString("E_CLAVE"));
                empleado.setNombre(resultSet.getString("E_NOMBRE"));
                empleado.setCargo(resultSet.getString("E_CARGO"));
                empleado.setFechaRegistro(resultSet.getDate("E_FECHA_REG"));
                empleado.setEmail(resultSet.getString("E_EMAIL"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    // Métodos CRUD para la tabla USUARIO
    // (Similar a los métodos anteriores)

    // Métodos CRUD para la tabla USUARIO
    public void insertUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIO (U_NOMBRE, U_PASSWORD, FK_CLAVE) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getClaveEmpleado());
            preparedStatement.executeUpdate();
        }
    }

    public void updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO SET U_NOMBRE=?, U_PASSWORD=?, WHERE FK_CLAVE=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getPassword());
            preparedStatement.setString(3, usuario.getClaveEmpleado());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteUsuario(String clave) throws SQLException {
        String sql = "DELETE FROM USUARIO WHERE FK_CLAVE=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, clave);
            preparedStatement.executeUpdate();
        }
    }

    public List<Usuario> getAllUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(resultSet.getString("U_NOMBRE"));
                usuario.setPassword(resultSet.getString("U_PASSWORD"));
                usuario.setClaveEmpleado(resultSet.getString("FK_CLAVE"));
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Métodos CRUD para la tabla INSUMO
    // (Similar a los métodos anteriores)

    public void insertInsumo(Insumo insumo) throws SQLException {
        String sql = "INSERT INTO INSUMO (I_CLAVE, I_NOMBRE, I_CANTIDAD, I_TIPO, I_FECHA_ING, I_HORA_ING, FK_CLAVE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, insumo.getClave());
            preparedStatement.setString(2, insumo.getNombre());
            preparedStatement.setInt(3, insumo.getCantidad());
            preparedStatement.setString(4, insumo.getTipo());
            preparedStatement.setDate(5, insumo.getFechaIngreso());
            preparedStatement.setTime(6, insumo.getHoraIngreso());
            preparedStatement.setString(7, insumo.getClaveEmpleado());
            preparedStatement.executeUpdate();
        }
    }

    public void updateInsumo(Insumo insumo) {
        String sql = "UPDATE INSUMO SET I_NOMBRE=?, I_CANTIDAD=? WHERE I_CLAVE=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, insumo.getNombre());
            preparedStatement.setInt(2, insumo.getCantidad());
            preparedStatement.setString(3, insumo.getClave());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime la traza de la excepción
            // También puedes usar un logger para registrar la excepción
        }
    }


    public void deleteInsumo(String clave) throws SQLException {
        String sql = "DELETE FROM INSUMO WHERE I_CLAVE=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, clave);
            preparedStatement.executeUpdate();
        }
    }

    public List<Insumo> getAllInsumos() throws SQLException {
        List<Insumo> insumos = new ArrayList<>();
        String sql = "SELECT * FROM INSUMO";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Insumo insumo = new Insumo();
                insumo.setClave(resultSet.getString("I_CLAVE"));
                insumo.setNombre(resultSet.getString("I_NOMBRE"));
                insumo.setCantidad(resultSet.getInt("I_CANTIDAD"));
                insumo.setTipo(resultSet.getString("I_TIPO"));
                insumo.setFechaIngreso(resultSet.getDate("I_FECHA_ING"));
                insumo.setHoraIngreso(resultSet.getTime("I_HORA_ING"));
                insumo.setClaveEmpleado(resultSet.getString("FK_CLAVE"));
                insumos.add(insumo);
            }
        }
        return insumos;
    }
}
