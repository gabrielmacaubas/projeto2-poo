package regras_negocio;
/**********************************
 * Projeto2 de POO (2022.2)
 * 
 * Grupo de alunos: 
 * fulano, beltrano e cicrano
 * 
 **********************************/

import java.util.ArrayList;

import modelo.Ingresso;
import modelo.IngressoGrupo;
import modelo.IngressoIndividual;
import modelo.Jogo;
import modelo.Time;
import repositorio.Repositorio;


public class Fachada {
	private static Repositorio repositorio = new Repositorio();	
	private Fachada() {}	
	
	public static ArrayList<Time> listarTimes() {
		//retorna todos os times do repositório
		return repositorio.getTimes();
	}

	public static ArrayList<Jogo> listarJogos() {
		//retorna todos os jogos do repositório
		return repositorio.getJogos();
	}
	
	public static ArrayList<Ingresso> listarIngressos() {
		//retorna todos os ingressos do repositório 
		return repositorio.getIngressos();
	}

	public static ArrayList<Jogo> listarJogos(String data) {
		//retorna os jogos do repositório na data fornecida
		ArrayList<Jogo> JogosTemp = repositorio.getJogos();
		ArrayList<Jogo> JogosData = new ArrayList<Jogo>();

		for(Jogo j : JogosTemp) {
			if (j.getData().equals(data)) {
				JogosData.add(j);
			}
		}

		return JogosData;
	}

	public static Ingresso localizarIngresso(int codigo) {
		//retorna o ingresso do repositório com o código fornecido
		//...
		return repositorio.localizarIngresso(codigo);
	}
	
	public static Jogo localizarJogo(int id) {
		//retorna o jogo do repositório com o id fornecido
		//...
	}
	
	public static Time 	criarTime(String nome, String origem) throws Exception {
		//Exceção: nome existente no repositorio
		//criar o time
		//adicionar este time no repositório
		//salvar o repositorio em arquivo
	}

	public static Jogo 	criarJogo(String data, String local, int estoque, double preco, String nometime1, String nometime2)  throws Exception {
		
		//Exceção: nometime1 ou nometime2 inexistente no repositorio, 
		//  local ou data vazios, estoque ou preço menor ou igual a zero
		//gerar id sequencial do jogo 
		//criar o jogo, 
		//relacionar o jogo com os dois times 
		//adicionar este jogo no repositório
		//salvar o repositorio em arquivo
	}
	
	public static void 	apagarJogo(int id) throws Exception{
		//Exceção: id inexistente no repositorio
		//remover o jogo do repositório
		//salvar o repositorio em arquivo
	}

	public static IngressoIndividual criarIngressoIndividual(int id) throws Exception{
		//Exceção: id inexistente no repositorio
		//gerar codigo aleatório e verificar unicididade do codigo no jogo indicado
		//criar o ingresso individual 
		//relacionar este ingresso com o jogo indicado
		//adicionar este ingresso no repositório
		//salvar o repositorio em arquivo
	}
	
	public static IngressoGrupo	criarIngressoGrupo(int[] id) throws Exception{
		//Exceção: id inexistente no repositorio 
		//gerar codigo aleatório e verificar unicididade do codigo nos jogos indicados
		//criar o ingresso de grupo, 
		//relacionar este ingresso com os jogos indicados 
		//adicionar este ingresso no repositório
		//salvar o repositorio em arquivo
	}
	
	public static void	cancelarIngresso(int codigo) throws Exception {
		//Exceção: codigo inexistente no repositorio
		//remover o relacionamento entre ele e o(s) jogo(s) ligados a ele
		//remover ingresso do repositório 
		//salvar o repositorio em arquivo
	}
}
