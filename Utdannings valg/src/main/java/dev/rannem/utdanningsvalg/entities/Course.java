package dev.rannem.utdanningsvalg.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;
    private String description;

}
