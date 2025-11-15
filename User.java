package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados e
 * verificar a autenticação de usuários.
 */
public class User {

    /**
     * Tenta estabelecer uma conexão com o banco de dados MySQL.
     * 
     * @return Objeto Connection ou null em caso de falha.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Tratamento de exceção inadequado (apenas retorna null), causando problema 8.
            return conn;
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    /**
     * Verifica se o login e senha fornecidos correspondem a um usuário no banco.
     * O fluxo deste método é usado para o cálculo das métricas de complexidade
     * (V(G)=3).
     */
    public boolean verificarUsuario(String login, String senha) {

        // N1: Início do Método
        String sql = ""; // N2: Inicialização da string SQL
        Connection conn = conectarBD(); // N3: Chamada para obter conexão

        // N4: Construção da query SQL (Vulnerável a SQL Injection)
        // INSTRUÇÃO SQL
        sql = "select nome from usuarios ";
        sql += "Where login = '" + login + "'";
        sql += " and senha = '" + senha + "';";

        // N5: PREDICADO 1 - TRY (Ponto de Decisão: Sucesso ou Exceção)
        try {
            // CUIDADO: Se conn for null (problema 5), lança NullPointerException aqui.
            Statement st = conn.createStatement(); // N6: Criação do Statement
            ResultSet rs = st.executeQuery(sql); // N7: Execução da Query

            // N8: PREDICADO 2 - IF (Ponto de Decisão: True ou False)
            if (rs.next()) {

                // N9: Se rs.next() for verdadeiro
                result = true;

                // N10: Obtenção do resultado
                nome = rs.getString("nome");

            } // (Aresta N8 -> N12 se for falso)

        } catch (Exception e) {

            // N11: Se ocorrer Exceção (Aresta N7 -> N11)
            // Tratamento genérico, não fecha recursos (problema 8).

        } // (Aresta N10 -> N12 ou N11 -> N12)

        return result; // N12: Fim/Saída do Método
    }
    // fim da classe
}