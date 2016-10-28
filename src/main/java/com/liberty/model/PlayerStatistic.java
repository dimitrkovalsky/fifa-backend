package com.liberty.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.liberty.common.DateHelper.toReadableString;

@Data
@Document(collection = "player_statistic")
public class PlayerStatistic {

  private Long id;
  private Integer lastPrice;

  private LocalDateTime innerDate;

  public String getDate() {
    return toReadableString(innerDate);
  }

  private List<PriceDistribution> prices = new ArrayList<>();


  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class PriceDistribution {

    private Integer price;
    private Integer amount;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class HistoryPoint {

    private Long minPrice;
    private Long median;
  }
}


