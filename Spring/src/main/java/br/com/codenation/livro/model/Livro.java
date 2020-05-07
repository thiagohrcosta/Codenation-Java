package br.com.codenation.livro.model;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE);
    private Long id;

    private String titulo;

    @OneToMany
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    private List<Categoria> categorias;

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    public Livro(){
        super();
    }


}
