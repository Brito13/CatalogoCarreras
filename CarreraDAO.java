package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {

    public List<String> obtenerCarrerasPorEscuela(String escuela) {

        List<String> carreras = new ArrayList<>();

        String sql = "SELECT nombre FROM carreras WHERE escuela = ?";

        try {
            Connection conn = ConexionBD.obtenerConexion();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, escuela);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                carreras.add(rs.getString("nombre"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return carreras;
    }
}