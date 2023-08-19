package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Funcionario;

public class FuncionarioDao {

    public void create(){
        String create = "CREATE TABLE IF NOT EXISTS funcionarios ("+
        "id INT AUTO_INCREMENT PRIMARY KEY,"+
        "nome VARCHAR(100) NOT NULL,"+
        "horasTrabalhadas DOUBLE NOT NULL,"+
        "horasValor DOUBLE NOT NULL)"+
        "";

        try(Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(create)){

                preparedStatement.executeUpdate();
                System.out.println("TABELA CRIADA COM SUCESSO!");
            }catch(SQLException e){
                e.printStackTrace();
            }
    }

    public void insert(Funcionario funcionario){

        String insertSql = "INSERT INTO funcionarios (nome, horasTrabalhadas, horasValor) VALUES (?, ?, ?)";

        try(Connection connection = Config.getConnection();
            PreparedStatement preparableStatement = connection.prepareStatement(insertSql)){
                    preparableStatement.setString(1, funcionario.getNome());
			        preparableStatement.setDouble(2, funcionario.getHorasTrabalhadas());
			        preparableStatement.setDouble(3, funcionario.getHorasValor());

                    
                    preparableStatement.executeUpdate();
                    System.out.println("Funcionário cadastrado com sucesso!");

        }catch (SQLException e){
            System.out.println("Erro");
            e.getStackTrace();
        }
    }
    
    public void update(Funcionario funcionario){
        String updateQuery = "UPDATE funcionarios SET nome = ?, horasTrabalhadas = ?, horasValor = ? WHERE id = ?";

        try (Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
                preparedStatement.setString(1, funcionario.getNome());
                preparedStatement.setDouble(2, funcionario.getHorasTrabalhadas());
                preparedStatement.setDouble(3, funcionario.getHorasValor());
                preparedStatement.setInt(4, funcionario.getId());

                preparedStatement.executeUpdate();
                System.out.println("Usuário editado com sucesso!");


            } catch (SQLException e){
                System.out.println("Erro ao atualizar");
                e.printStackTrace();
            }

    }

    public void delete(Funcionario funcionario){
        String deleteQuery = "DELETE FROM funcionarios WHERE id=?";

        try(Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
                preparedStatement.setInt(1, funcionario.getId());

                preparedStatement.executeUpdate();
                System.out.println("Deletado com sucesso!");

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao deletar");
        }
    }

    public List<Funcionario> getAll(){
        List<Funcionario> funcionarios = new ArrayList<>();
        String listQuery = "SELECT * FROM funcionarios";

        try(Connection connection = Config.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(listQuery);
            ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(resultSet.getInt("id"));
                    funcionario.setNome(resultSet.getString("nome"));
                    funcionario.setHorasTrabalhadas(resultSet.getDouble("horasTrabalhadas"));
                    funcionario.setHorasValor(resultSet.getDouble("horasValor"));

                    funcionarios.add(funcionario);
                }

            }catch(SQLException e){
                e.printStackTrace();
            }

            return funcionarios;

    }

}
