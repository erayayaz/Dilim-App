package com.example.Dilim.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "news_eng")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder
public class NewsEng implements Serializable {

    @Id
    @SequenceGenerator(name="seq_new_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_new_id", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String source;
    @Column(length = 500, name="description")
    private String description;
    private String createdDate;
}