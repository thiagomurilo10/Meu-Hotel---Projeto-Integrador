package DadosHotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HotelDao {

    private Conexao conexao;
    private Connection conn;

    public HotelDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void salvar(DadosHotel hotel) {
        String sql = "INSERT INTO cliente(nome, telefone, cpf, data_consulta, jaEraCliente) VALUES " + "(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, hotel.getNome());
            stmt.setString(2, hotel.getTelefone());
            stmt.setString(3, hotel.getCpf());
            stmt.setString(4, hotel.getDataDaConsulta());
            stmt.setString(5, hotel.getJaEraPaciente());
            stmt.execute();

            JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }

    public List<DadosHotel> getDadosHotel(String nome) {  //parâmetro para buscar a empresa pelo nome
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";  //LIKE nos permite pesquisar por partes de um nome, ao invés de pesquisarmos por todo nome
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //Como temos um parâmetro, devemos defini-lo
            stmt.setString(1, "%" + nome + "%"); //Conforme for a palavra ou letra digitada para pesquisa, será buscada antes, no meio e no fim
            //Método para poder executar o SELECT.
            //Os resultados obtivos pela consulta serão armazenados na variavel ResultSet
            ResultSet rs = stmt.executeQuery();

            //Vamos criar um objeto do tipo List
            //Faça a importação do ArrayList
            List<DadosHotel> listaCenaflix = new ArrayList<>();
            //percorrer o resultSet e salvar as informações dentro de uma variável "Empresa"
            //Depois salva esse objeto dentro da lista

            //Estrutura de repetição While
            while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                DadosHotel hotel = new DadosHotel();
                //Salvar dentro do objeto empresa as informações
                hotel.setId(rs.getInt("id"));
                hotel.setNome(rs.getString("nome"));
                hotel.setTelefone(rs.getString("telefone"));
                hotel.setCpf(rs.getString("cpf"));
                hotel.setDataDaConsulta(rs.getString("data_consulta"));
                hotel.setJaEraPaciente(rs.getString("jaEraCliente"));
                //Adicionando os elementos na lista criada
                listaCenaflix.add(hotel);
            }
            //Após finalizar o while, o retorno será a listaEmpresas, onde cada posição é um registro do banco de dados
            return listaCenaflix;
            //Se o método entrar no "Catch" quer dizer que não encontrou nenhuma empresa, então damos um "return null"
        } catch (Exception e) {
            return null;
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
            //esse trecho é igual ao método editar e inserir
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executando a query
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso");
            //tratando o erro, caso ele ocorra
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir filme: " + e.getMessage());
        }
    }

}
