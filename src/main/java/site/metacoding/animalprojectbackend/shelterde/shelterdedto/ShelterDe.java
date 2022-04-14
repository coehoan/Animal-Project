package site.metacoding.animalprojectbackend.shelterde.shelterdedto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShelterDe {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header Header;
        private Body Body;

        @AllArgsConstructor
        @Data
        class Header {
            private Integer resultCode;
            private String resultMsg;
        }

        @AllArgsConstructor
        @Data
        class Body {
            private Items items;
            private Integer numOfRows;
            private Integer pageNo;
            private Integer totalCount;

            @AllArgsConstructor
            @Data
            class Items {
                private List<Item> item;

                @AllArgsConstructor
                @Data
                class Item {
                    private String careNm;//
                    private String orgNm;//
                    private String divisionNm;//
                    private String saveTrgtAnimal;//
                    private String careAddr;//
                    private String jibunAddr;//
                    // private String lat;//
                    // private String lng;//
                    // private String dsignationDate;//
                    private String weekOprStime;//
                    private String weekOprEtime;//
                    private String weekCellStime;//
                    private String weekCellEtime;//
                    private String weekendOprStime;//
                    private String weekendOprEtime;//
                    private String weekendCellStime;//
                    private String weekendCellEtime;//
                    private String closeDay;//
                    private String careTel;//
                    // private Integer vetPersonCnt;//
                    // private Integer specsPersonCnt;//
                    // private String medicalCnt;//
                    // private Integer breedCnt;//
                    // private String quarabtineCnt;//
                    // private String feedCnt;//
                    // private String transCarCnt;//
                    // private String dataStdDt;//
                }
            }
        }
    }
}