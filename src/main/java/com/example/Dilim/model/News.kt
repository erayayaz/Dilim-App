package com.example.Dilim.model

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
data class News(
        @Id
        @Column(name = "news_id", unique = true, nullable = false, length = 20)
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        val id: Int?,
        val titleTr: String,
        val titleEng: String ,
        val source: String,
        val descriptionTr: String?,
        val descriptionEng: String?,
        val createdDate: String?,
        val updatedDate: String?
) {

}