package site.metacoding.animalprojectfrontend.config.shelter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Shelter01 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String careNm;
    private String orgNm;
    private String divisionNm;
    private String saveTrgtAnimal;
    private String careAddr;
    private String jibunAddr;
    private String weekOprEtime;
    private String weekOprStime;
    private String closeDay;
    private String careTel;

}
