/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "MovimentoVenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentoVenda.findAll", query = "SELECT m FROM MovimentoVenda m"),
    @NamedQuery(name = "MovimentoVenda.findByIdMovimentoVenda", query = "SELECT m FROM MovimentoVenda m WHERE m.idMovimentoVenda = :idMovimentoVenda"),
    @NamedQuery(name = "MovimentoVenda.findByQuantidade", query = "SELECT m FROM MovimentoVenda m WHERE m.quantidade = :quantidade")})
public class MovimentoVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimentoVenda")
    private Integer idMovimentoVenda;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    @ManyToOne
    private PessoaFisica cpf;
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto idProduto;

    public MovimentoVenda() {
    }

    public MovimentoVenda(Integer idMovimentoVenda) {
        this.idMovimentoVenda = idMovimentoVenda;
    }

    public Integer getIdMovimentoVenda() {
        return idMovimentoVenda;
    }

    public void setIdMovimentoVenda(Integer idMovimentoVenda) {
        this.idMovimentoVenda = idMovimentoVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public PessoaFisica getCpf() {
        return cpf;
    }

    public void setCpf(PessoaFisica cpf) {
        this.cpf = cpf;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentoVenda != null ? idMovimentoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentoVenda)) {
            return false;
        }
        MovimentoVenda other = (MovimentoVenda) object;
        if ((this.idMovimentoVenda == null && other.idMovimentoVenda != null) || (this.idMovimentoVenda != null && !this.idMovimentoVenda.equals(other.idMovimentoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.MovimentoVenda[ idMovimentoVenda=" + idMovimentoVenda + " ]";
    }
    
}
