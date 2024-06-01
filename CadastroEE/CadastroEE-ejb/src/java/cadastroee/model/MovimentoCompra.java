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
import java.math.BigDecimal;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "MovimentoCompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentoCompra.findAll", query = "SELECT m FROM MovimentoCompra m"),
    @NamedQuery(name = "MovimentoCompra.findByIdMovimentoCompra", query = "SELECT m FROM MovimentoCompra m WHERE m.idMovimentoCompra = :idMovimentoCompra"),
    @NamedQuery(name = "MovimentoCompra.findByQuantidade", query = "SELECT m FROM MovimentoCompra m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "MovimentoCompra.findByPrecounitario", query = "SELECT m FROM MovimentoCompra m WHERE m.precounitario = :precounitario")})
public class MovimentoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimentoCompra")
    private Integer idMovimentoCompra;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precounitario")
    private BigDecimal precounitario;
    @JoinColumn(name = "cnpj", referencedColumnName = "cnpj")
    @ManyToOne
    private PessoaJuridica cnpj;
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @ManyToOne
    private Produto idProduto;

    public MovimentoCompra() {
    }

    public MovimentoCompra(Integer idMovimentoCompra) {
        this.idMovimentoCompra = idMovimentoCompra;
    }

    public Integer getIdMovimentoCompra() {
        return idMovimentoCompra;
    }

    public void setIdMovimentoCompra(Integer idMovimentoCompra) {
        this.idMovimentoCompra = idMovimentoCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public PessoaJuridica getCnpj() {
        return cnpj;
    }

    public void setCnpj(PessoaJuridica cnpj) {
        this.cnpj = cnpj;
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
        hash += (idMovimentoCompra != null ? idMovimentoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentoCompra)) {
            return false;
        }
        MovimentoCompra other = (MovimentoCompra) object;
        if ((this.idMovimentoCompra == null && other.idMovimentoCompra != null) || (this.idMovimentoCompra != null && !this.idMovimentoCompra.equals(other.idMovimentoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.MovimentoCompra[ idMovimentoCompra=" + idMovimentoCompra + " ]";
    }
    
}
