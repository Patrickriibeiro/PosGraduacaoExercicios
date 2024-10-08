package br.com.patrickriibeiro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "USUARIO", schema = "forum")
public class Forum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDFORUM")
    private int id;

    @Column(name = "ASSUNTO", length = 45)
    private String assunto;

    @Column(name = "DESCRICAO", length = 45)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forum")
    private Set<Usuario> usuarios = new HashSet<Usuario>();

    public Forum(int id, String assunto, String descricao, Set<Usuario> usuarios) {
        this.id = id;
        this.assunto = assunto;
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    public Forum() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
