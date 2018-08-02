/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gxs.usuario;

import br.com.gxs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author guana
 */
public class UsuarioDAO {

    public static void main(String[] args) {
        adicionar();
    }

    private UsuarioDAO() {
    }

    private static void adicionar() {

        Usuario user = new Usuario();
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        String sql = "insert into usuario (login,senha,nome,email,situacao) values (?,?,?,?,?)";
        PreparedStatement ps;

        try {

            ps = conn.prepareStatement(sql);

            //ps.setString(1, txtUsuId.getText());
            //ps.setString(1, user.);
            ps.setString(1, "foi");
            ps.setString(2, "123");
            ps.setString(3, "ddaaaSTANDO");
            ps.setString(4, "testesa@tasfas.com");
            ps.setString(5, "ativo");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
 public class CarroDAO implements CrudDAO<Carro>{

    

 @Override

 public void salvar(Carro carro) throws ErroSistema{

 try {

 Connection conexao = FabricaConexao.getConexao();

 PreparedStatement ps;

 if(carro.getId() == null){

 ps = conexao.prepareStatement("INSERT INTO `carro` (`modelo`,`fabricante`,`cor`,`ano`) VALUES (?,?,?,?)");

 } else {

 ps = conexao.prepareStatement("update carro set modelo=?, fabricante=?, cor=?, ano=? where id=?");

 ps.setInt(5, carro.getId());

 }

 ps.setString(1, carro.getModelo());

 ps.setString(2, carro.getFabricante());

 ps.setString(3, carro.getCor());

 ps.setDate(4, new Date(carro.getAno().getTime()));

 ps.execute();

 FabricaConexao.fecharConexao();

 } catch (SQLException ex) {

 throw new ErroSistema("Erro ao tentar salvar!", ex);

 }

 }

    

 @Override

 public void deletar(Carro carro) throws ErroSistema{

 try {

 Connection conexao = FabricaConexao.getConexao();

 PreparedStatement ps  = conexao.prepareStatement("delete from carro where id = ?");

 ps.setInt(1, carro.getId());

 ps.execute();

 } catch (SQLException ex) {

 throw new ErroSistema("Erro ao deletar o carro!", ex);

 }

 }

    

 @Override

 public List<Carro> buscar() throws ErroSistema{

 try {

 Connection conexao = FabricaConexao.getConexao();

 PreparedStatement ps = conexao.prepareStatement("select * from carro");

 ResultSet resultSet = ps.executeQuery();

 List<Carro> carros = new ArrayList<>();

 while(resultSet.next()){

 Carro carro = new Carro();

 carro.setId(resultSet.getInt("id"));

 carro.setModelo(resultSet.getString("modelo"));

 carro.setFabricante(resultSet.getString("fabricante"));

 carro.setCor(resultSet.getString("cor"));

 carro.setAno(resultSet.getDate("ano"));

 carros.add(carro);

 }

 FabricaConexao.fecharConexao();

 return carros;

            

 } catch (SQLException ex) {

 throw new ErroSistema("Erro ao buscar os carros!",ex);

 }

 }

 }
 */