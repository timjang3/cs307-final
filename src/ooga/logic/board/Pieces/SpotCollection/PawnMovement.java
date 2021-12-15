package ooga.logic.board.Pieces.SpotCollection;

import java.util.List;

import ooga.logic.board.coordinate.Coordinate;
import ooga.logic.board.coordinate.GameCoordinate;

/**
 * Class that stores the possible coordinates a Pawn could move to from a given coordinate
 */

public class PawnMovement extends SpotCollection {
  private static final String PIECE_AS_STRING = "pawnMovement";

  /**
   * Pass width back to define bounds
   * @param width max of width of height of board
   */
  public PawnMovement(int width){
    super(width);
  }

  /**
   * return a list of list of coordinates, where within each list a coordinate being reached
   * depends on the coordinate before it
   * @param myCoordinate the coordinate we are currently at
   * @return the coordinates we could reach with no regard to bounds
   */
  @Override
  public List<List<Coordinate>> getPossibleSpots(Coordinate myCoordinate) {
    List<List<Coordinate>> mySpots = OneTimePossibleSpots(PIECE_AS_STRING, myCoordinate);
    if (myCoordinate.getY_pos() == 1){
      Coordinate myCoord = new GameCoordinate(myCoordinate.getX_pos(),myCoordinate.getY_pos() + 2);
      mySpots.get(0).add(myCoord);
    }

    return mySpots;
  }
}
