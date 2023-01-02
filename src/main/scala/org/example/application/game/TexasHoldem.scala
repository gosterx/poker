package org.example.application
package game

import domain.{Board, Hand}
import combination.{Combination, TexasHoldemSolver}

import org.example.application.comparing.{CombinationsComparator, ComparingStatus, TexasHoldemCombinationsComparator}

object TexasHoldem extends Game {
  private def getBestHandCombination(combinations: List[Combination]): Combination =
    combinations.reduceLeft { (c1, c2) =>
      if (c1.power > c2.power) c1 else c2
    }

  override def process(board: Board, hands: List[Hand]): List[Hand] =
    hands
      .map { hand =>
        (hand, getBestHandCombination(TexasHoldemSolver.all.flatMap(_.of(board, hand))))
      }
      .sortWith {
        case ((_, c1), (_, c2)) =>
          TexasHoldemCombinationsComparator.compare(c1, c2) match {
            case ComparingStatus.Stronger => true
            case ComparingStatus.Weaker   => false
            case ComparingStatus.Equal    => true
          }
      }
      .map { case (hand, _) => hand }
}
