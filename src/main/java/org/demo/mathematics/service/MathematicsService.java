package org.demo.mathematics.service;

import org.demo.mathematics.exception.MathematicsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MathematicsService {
    /**
     * 引数のリストの合計値を算出し、返却する
     * @param list 数値のリスト
     * @return 合計値
     */
    public double sum(List<Double> list) {
        return list.stream()
                .filter(x -> x != null)
                .mapToDouble(x -> x)
                .sum();
    }

    /**
     * 引数のリストの平均値を算出し、返却する
     * @param list 数値のリスト
     * @return 平均値
     */
    public double mean(List<Double> list) {
        return list.stream()
                .filter(x -> x!=null)
                .mapToDouble(x -> x)
                .average()
                .getAsDouble();
    }

    /**
     * 引数のリストの標準偏差を算出し、返却する
     * @param list 数値の配列
     * @param ddof N-ddof (Delta Degrees of Freedom)
     * @return 標準偏差
     */
    public double std(List<Double> list, int ddof) throws MathematicsException {
        if (ddof < 0 || list.stream().filter(x -> x!=null).count() - ddof <= 0) {
            throw new MathematicsException("標準偏差の算出ができませんでした");
        }
        double mu = mean(list);
        double sigma = list.stream()
                .filter(x -> x!=null)
                .mapToDouble(x -> Math.pow(x-mu, 2))
                .sum();
        return Math.sqrt(sigma / (list.stream().filter(x -> x!=null).count() - ddof));
    }

    /**
     * 引数のリストの外れ値を算出し、返却する
     * @param list 数値の配列
     * @return 外れ値
     */
    public double outlier(List<Double> list) throws MathematicsException {
        List<Double> logScaleList = list.stream()
                .filter(x -> x!=null)
                .map(x -> Math.log(x))
                .collect(Collectors.toList());
        double mu = mean(logScaleList);
        double rho = std(logScaleList, 0);
        return Math.exp(mu + rho * 2);
    }
}
