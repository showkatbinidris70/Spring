package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nominee")
public class Nominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomi_name", nullable = false)
    private String nomineeName;

    @Column(name = "nomi_age", nullable = false)
    private int nomineeAge;

    @Temporal(TemporalType.DATE)
    @Column(name = "nomi_birth_date", nullable = false)
    private Date nomineeBirthDate;

    @Column(name = "nomi_gender", nullable = false)
    private String nomineeGender;

    @Column(name = "nomi_address", nullable = false)
    private String nomineeAddress;

    @Column(name = "nomi_mobile", nullable = false)
    private String nomineeMobile;


    @Column(name = "nomi_nid", nullable = false, unique = true)
    private String nomineeNid;


    //Nominee Relation with AccountHolder
    @Column(name = "nomi_relation", nullable = false)
    private String nomineeRelation;


}
