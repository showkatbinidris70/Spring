package entity;

import javax.persistence.*;

@Entity
@Table(name = "collection_type")
public class CollectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;

}