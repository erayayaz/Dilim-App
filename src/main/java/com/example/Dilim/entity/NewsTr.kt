package com.example.Dilim.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "news_tr")
@AllArgsConstructor
@NoArgsConstructor
data class NewsTr(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: Long?,
        val title: String ,
        val source: String,
        @Column(length = 500, name = "description")
        val description: String?,
        val createdDate: String
) {

}
