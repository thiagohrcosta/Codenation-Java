package challenge;

import lombok.*;

import javax.persistence.*;


@Entity(name = "scripts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String actor;
	@Column(name = "detail")
	private String quote;

}
