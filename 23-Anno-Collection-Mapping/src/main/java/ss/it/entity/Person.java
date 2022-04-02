package ss.it.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="HB_ANNO_COLL_Person")
public class Person {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private String address;

	@ElementCollection
	@CollectionTable(name = "HB_ANNO_COLL_MAP_Nicknames", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "pid"))
	@Column(name = "NICKNAME", length = 10)
	@OrderColumn(name = "nname_Indx")
	@ListIndexBase(value = 1)
	private List<String> nickNames;
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_COLL_Friends", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "pid"))
	@Column(name = "Friend", length = 10)
	private List<String> friends;
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_COLL_Phones", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "pid"))
	@Column(name = "phone", length = 15)
	private Set<Long> phones;
	@ElementCollection
	@CollectionTable(name = "HB_ANNO_COLL_IDCards", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "pid"))
	@MapKeyColumn(name = "idType", length = 10)
	@Column(name = "id_no", length = 15)
	private Map<String, Long> idCards;

}
