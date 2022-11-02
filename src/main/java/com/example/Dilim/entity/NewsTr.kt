package com.example.Dilim.entity

import com.example.Dilim.dto.NewsTrDto
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "news_tr")
@AllArgsConstructor
@NoArgsConstructor
internal data class NewsTr(
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

        companion object {
                fun fromDto(dto: NewsTrDto, newsTr: NewsTr) = NewsTr (
                        id = dto.id!!,
                        title = dto.title ?: newsTr.title,
                        source = dto.source ?: newsTr.source,
                        description = dto.description ?: newsTr.source,
                        createdDate = dto.createdDate ?: newsTr.getDate()
                )
        }

        fun getDate() : String {
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
               return current.format(formatter)
        }

}
