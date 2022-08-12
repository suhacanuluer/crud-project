package com.example.crudproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class PersonEntity {

    @Id
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private Boolean isStudent;

    // Eğer @OneToOne veya @ManyToOne tipinde ilişki bulunan veritabanınlarından yararlanıyorsak,
    // FetchType olarak EAGER(Ön Yükleme) kullanmak daha doğrudur.
    // Yani ilişkili entity bir tane olduğundan ön yükleme yapmak performans açısından bir sorun oluşturmaz.
    //
    // Eğer ki  @OneToMany veya  @ManyToMany kullanıyorsak da
    // FetchType olarak LAZY(Tembel Yükleme) kullanmak daha doğrudur.
    // Çünkü ilişkili entityler çok sayıda olması halinde ön yükleme yapacak olursak
    // bu durum performans kaybına neden olur. Bunun için ihtiyaç olması halinde yüklemek daha doğru bir çözüm olur.
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    // cascade: ilişkili sınıfların birbirlerinden etkilenip etkilenmemesini sağlıyor.
    // ALL:  tüm işlemleri ilişkili nesnelerle birlikte yapar
    // mappedBy????
    private List<TodoEntity> todos;
}
