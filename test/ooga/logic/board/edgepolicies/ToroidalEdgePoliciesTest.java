package ooga.logic.board.edgepolicies;

import ooga.logic.board.coordinate.Coordinate;
import ooga.logic.board.coordinate.GameCoordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ToroidalEdgePoliciesTest {
    @Test
    public void allWithinBoundTest()
    {
        List<List<Coordinate>> bigList = new ArrayList<>();
        List<Coordinate> a=new ArrayList<>();
        List<List<Coordinate>> c;
        a.add(new GameCoordinate(3,4));
        a.add(new GameCoordinate(0,0));
        a.add(new GameCoordinate(2,1));
        ToroidalEdgePolicies b=new ToroidalEdgePolicies(5,5);
        bigList.add(a);
        c=b.filterList(bigList);
        Assertions.assertEquals(getSize(bigList),getSize(c));
    }

    @Test
    public void xOutsideBoundTest()
    {
        List<List<Coordinate>> bigList = new ArrayList<>();
        List<Coordinate> a=new ArrayList<>();
        List<List<Coordinate>> c;
        a.add(new GameCoordinate(3,4));
        a.add(new GameCoordinate(6,0));
        a.add(new GameCoordinate(-2,0));
        a.add(new GameCoordinate(2,1));
        ToroidalEdgePolicies b=new ToroidalEdgePolicies(5,5);
        bigList.add(a);
        c=b.filterList(bigList);
        Assertions.assertTrue(c.get(0).get(1).getX_pos()==1&&c.get(0).get(2).getX_pos()==3);
    }


    @Test
    public void yOutsideBoundTest()
    {
        List<List<Coordinate>> bigList = new ArrayList<>();
        List<Coordinate> a=new ArrayList<>();
        List<List<Coordinate>> c;
        a.add(new GameCoordinate(0,4));
        a.add(new GameCoordinate(0,-2));
        ToroidalEdgePolicies b=new ToroidalEdgePolicies(5,5);
        bigList.add(a);
        c=b.filterList(bigList);
        Assertions.assertTrue(getSize(c)==1);
    }
    private int getSize(List<List<Coordinate>> myCoords) {
        int size = 0;
        for (List<Coordinate> x : myCoords){
            size += x.size();
        }
        return size;
    }
}
