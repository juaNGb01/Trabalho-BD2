/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;
import util.Conexao;
import util.UserSession;
/**
 *
 * @author juanb
 */
import java.sql.*;

public class UserDAO {

    public void autenticar(String user, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConn(user, password);
            
            String sql = "SELECT f.* " +
                "FROM tb_funcionarios f " +
                "JOIN pg_user p ON f.fun_nome = p.usename " +
                "WHERE f.fun_nome = ? AND f.fun_senha = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            if (rs.next()) {

                //caso exista insância um usuáriopgdumpPath
                Usuario loggedUser = new Usuario();
                loggedUser.setName(rs.getString("fun_nome"));
                loggedUser.setId(rs.getInt("fun_codigo"));
                loggedUser.setPassword(rs.getString("fun_senha"));


                //add esse usuário como logado
                UserSession.setuserLogged(loggedUser);

            } else {
                System.out.println("Usuario não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
