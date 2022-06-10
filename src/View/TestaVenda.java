
package View;

import Controller.BancoDados;
import Model.ItensProduto;
import java.sql.SQLException;
import Model.Produto;
import java.util.Scanner;
public class TestaVenda {
    
    	public static void main(String[] args) throws SQLException {
            Scanner teclado = new Scanner(System.in);


                Produto produto = new Produto();
                ItensProduto itens = new ItensProduto();
		BancoDados bancoDados = new BancoDados();
                
		bancoDados.conecta();
               
              
                
		if (bancoDados.estaConectado()) {
                    
                   produto.setNomeProduto("novo");
                   produto.setValorUnitario(50);
                   produto.setTipoUnidade("");
                   produto.setQtdEstoque(20);
                   bancoDados.inserir(produto);
                   
                    System.out.println("Lista de produtos:");
                    bancoDados.CarregarLista();
                    
                    System.out.print("Escolha um produto:");
                    int escolhaNum = teclado.nextInt();
                    
                    System.out.println("Adicionado ao carrinho!");
		     bancoDados.seleciona(escolhaNum);
                    System.out.print("Quantidade de compra: ");
		    int quantidade = teclado.nextInt();
                   
                   itens.setQtdVendida(quantidade); 
                   
                    bancoDados.atualizaEstoque(escolhaNum,quantidade);
                    
                    System.out.println("Estoque atual do produto!!");
                    bancoDados.seleciona(escolhaNum);
                    
		}
                
                else
                    
                {		
			System.out.println("Banco com defeito ");}
		}
}

      