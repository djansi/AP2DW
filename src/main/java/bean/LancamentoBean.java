package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.LancamentoDao;
import entidades.Lancamento;

import util.MessageUtil;

@ManagedBean
@ViewScoped
public class LancamentoBean implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Lancamento lancamento = new Lancamento();
	
	private Date dataCadastro = new Date();
	
	private List<Lancamento> list;
	
	private  String contarLancamento;
	
	private Double totalReceitas;
    private Double totalDespesas;
    private Double saldo;
    private String descricao;
    private String tipo;
    
	
	
		
		
	public String salvar() {
			
		try {			
			lancamento.setDataCadastro(dataCadastro);
			LancamentoDao.salvar(lancamento);
			MessageUtil.sucesso("Sucesso: ", "Lançamento criado com sucesso!");
			lancamento = new Lancamento();
				
		} catch(Exception e) {
			MessageUtil.erro("Erro: ", "Erro ao criar o Lancamento!");
		}
			
		return null;
		}
	

	public void deletar() {		
		LancamentoDao.deletar(lancamento);
		list = LancamentoDao.listarTodos();
	}
	
	
	public String listarTodos() {		
		LancamentoDao.listarTodos();
		return null;
	}		
	
	
	

	public List<Lancamento> getList() {
		if (list == null) {
			list = LancamentoDao.listarTodos();
		}
		return list;
	}
	
	public void setList(List<Lancamento> list) {
		this.list = list;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public String getContarLancamento() {
		
		if (list == null) {
			list = LancamentoDao.listarTodos();
		}
		return Integer.toString(list.size());
	}

	public void setContarLancamento(String contarLancamento) {
		this.contarLancamento = contarLancamento;
	}	
	
	
	private void calcularTotais() {
        totalReceitas = 0.0;
        totalDespesas = 0.0;

        for (Lancamento lancamento : list) {
            if ("receita".equalsIgnoreCase(lancamento.getTipo())) {
                totalReceitas += lancamento.getValor();
            } else if ("despesa".equalsIgnoreCase(lancamento.getTipo())) {
                totalDespesas += lancamento.getValor();
            }
        }

        saldo = totalReceitas - totalDespesas;
    }

    // Getters e Setters

			
									public Double getTotalReceitas() {
									    if (list == null) {
									        list = LancamentoDao.listarTodos();
									    }
									    
									    // Valor de receitas inicial = 0
									    Double totalReceitas = 0.0;
								
									 // Busca por RECEITAS na lista de lançamento
									    for (Lancamento lancamento : list) {
									        // Verifica se o tipo é RECEITA e soma ao VALORTOTAL
									        if ("receita".equalsIgnoreCase(lancamento.getTipo())) {
									            totalReceitas += lancamento.getValor();
									        }
									    }
									    
									    return totalReceitas;
									}
								
								    public void setTotalReceitas(Double totalReceitas) {
								        this.totalReceitas = totalReceitas;
								    }
    
    

    public Double getTotalDespesas() {
        if (list == null) {
            list = LancamentoDao.listarTodos();
        }
        
        // Valor de despesa inicial == 0
        Double totalDespesas = 0.0;

        // Busca por DESPESA na lista de lançamento
        for (Lancamento lancamento : list) {
            // Verifica se o tipo é uma DESPESA
            if ("despesa".equalsIgnoreCase(lancamento.getTipo())) {
                totalDespesas += lancamento.getValor();
            }
        }
        
        return totalDespesas;
    }

    public void setTotalDespesas(Double totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

   
    
									    public Double getSaldo() {
									        if (list == null) {
									            list = LancamentoDao.listarTodos();
									        }
									
									        // Variáveis locais para calcular os totais
									        Double totalReceitas = 0.0;
									        Double totalDespesas = 0.0;
									
									        for (Lancamento lancamento : list) {
									            if ("receita".equalsIgnoreCase(lancamento.getTipo())) {
									                totalReceitas += lancamento.getValor();
									            } else if ("despesa".equalsIgnoreCase(lancamento.getTipo())) {
									                totalDespesas += lancamento.getValor();
									            }
									        }
									
									        // Calcula o saldo
									        Double saldo = totalReceitas - totalDespesas;
									        return saldo;
									    }
									
									    public void setSaldo(Double saldo) {
									        this.saldo = saldo;
									    }

	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
    

}
