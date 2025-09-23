package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AllElementsInTwoBinarySearchTreesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getAllElements(TreeNode root1, TreeNode root2, List<Integer> expected) {
        var solution = new AllElementsInTwoBinarySearchTrees();
        assertEquals(expected, solution.getAllElements(root1, root2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {2,1,4}), buildTree(new Integer[]{1,0,3}), List.of(0,1,1,2,3,4)),
                Arguments.of(buildTree(new Integer[] {1,null,8}), buildTree(new Integer[]{8,1}), List.of(1,1,8,8)),
                Arguments.of(
                        buildTree(new Integer[] {55702,-37539,88067,-74833,-2631,78731,94847,-99583,-69580,-9879,50430,69594,79798,88382,98761,null,-93320,-71851,-64127,-35513,-3756,34141,54148,63618,73396,null,84397,null,92825,95477,99692,-99470,-86116,-72049,-71265,-67897,-47480,-37426,-30681,-4712,null,12785,48734,52071,54957,57693,66944,72189,74386,81816,85030,92060,94796,null,null,null,99782,null,-93432,-89332,-77109,-74384,null,-71710,-70766,null,-65593,-48834,-44272,null,-35949,-34095,-16053,-6546,-4298,3143,28913,47617,49453,50456,52388,54593,null,null,60055,64025,null,null,null,null,75678,null,null,null,87299,null,92355,null,null,null,null,-96387,null,-91118,-86650,-82961,null,null,-73586,-71711,null,null,null,-66654,null,-59892,null,-46351,-39225,null,-35711,null,null,-21243,-15079,-8193,null,null,null,-2541,11610,24082,34029,45094,48711,48802,50386,null,null,null,53356,null,null,null,61278,null,65233,null,null,86810,null,null,92445,-97204,-94958,-92457,-89405,-87378,null,null,-79805,null,-73337,null,null,null,-65840,-64068,-49814,-46424,null,-42254,-39036,null,null,-24650,-18639,null,-10705,-8942,null,null,1993,7397,null,13301,25305,29930,34120,40050,46157,null,null,null,null,null,null,52449,null,null,null,null,null,null,null,null,null,-98951,-96425,null,-93777,null,null,null,null,null,-86683,null,-79566,null,null,null,null,null,-63963,-58607,null,-47208,null,null,null,null,-39006,-26776,-22998,-19283,-17265,-10822,null,null,null,null,null,3291,11424,13194,19643,null,25334,29375,32368,null,null,37479,42254,null,47114,null,null,null,-98096,null,null,null,null,null,null,null,-79232,null,-61895,null,-56357,null,null,null,null,-29743,-24739,-23164,null,null,null,-17798,-17059,-11553,null,null,7002,null,null,null,null,16734,20530,null,28846,null,null,null,33394,34910,37827,40512,43602,46815,null,null,null,null,null,-63427,-60005,null,-52381,null,-27505,null,null,-24141,null,null,null,null,-16842,-13354,null,null,null,15614,null,19897,22782,null,null,null,null,null,35015,37544,null,null,41734,42820,null,null,null,-63786,-63272,-61058,null,null,-50902,null,null,null,-23818,null,-16356,null,-12804,15527,null,null,20110,null,null,null,36397,null,null,null,null,null,null,null,-63634,null,null,null,null,-52102,null,null,null,null,null,null,null,13989,null,null,null,35938}),
                        buildTree(new Integer[]{80195,11829,90151,-14438,62470,89516,93909,-82694,5069,46530,72326,null,null,null,96950,-99195,-34251,-12145,7074,30420,60289,null,79151,null,null,null,-98764,-79502,-17660,null,-11716,null,null,29804,31426,59664,62219,null,80091,null,-83172,-80767,-50445,-29681,-15208,null,-810,29457,null,null,32875,51863,null,null,null,null,null,-94375,null,null,null,-63524,-37982,-34008,-27147,null,null,-3847,null,null,null,null,41936,50272,59348,-96115,-90156,-74251,-50780,-43536,-36959,null,null,null,null,null,null,null,42622,null,51166,54148,null,null,null,null,-84909,null,null,-54718,null,null,null,null,null,null,null,null,null,null,null,null,null,null,-51333,null,-51016}),
                        Arrays.asList(-99583,-99470,-99195,-98951,-98764,-98096,-97204,-96425,-96387,-96115,-94958,-94375,-93777,-93432,-93320,-92457,-91118,-90156,-89405,-89332,-87378,-86683,-86650,-86116,-84909,-83172,-82961,-82694,-80767,-79805,-79566,-79502,-79232,-77109,-74833,-74384,-74251,-73586,-73337,-72049,-71851,-71711,-71710,-71265,-70766,-69580,-67897,-66654,-65840,-65593,-64127,-64068,-63963,-63786,-63634,-63524,-63427,-63272,-61895,-61058,-60005,-59892,-58607,-56357,-54718,-52381,-52102,-51333,-51016,-50902,-50780,-50445,-49814,-48834,-47480,-47208,-46424,-46351,-44272,-43536,-42254,-39225,-39036,-39006,-37982,-37539,-37426,-36959,-35949,-35711,-35513,-34251,-34095,-34008,-30681,-29743,-29681,-27505,-27147,-26776,-24739,-24650,-24141,-23818,-23164,-22998,-21243,-19283,-18639,-17798,-17660,-17265,-17059,-16842,-16356,-16053,-15208,-15079,-14438,-13354,-12804,-12145,-11716,-11553,-10822,-10705,-9879,-8942,-8193,-6546,-4712,-4298,-3847,-3756,-2631,-2541,-810,1993,3143,3291,5069,7002,7074,7397,11424,11610,11829,12785,13194,13301,13989,15527,15614,16734,19643,19897,20110,20530,22782,24082,25305,25334,28846,28913,29375,29457,29804,29930,30420,31426,32368,32875,33394,34029,34120,34141,34910,35015,35938,36397,37479,37544,37827,40050,40512,41734,41936,42254,42622,42820,43602,45094,46157,46530,46815,47114,47617,48711,48734,48802,49453,50272,50386,50430,50456,51166,51863,52071,52388,52449,53356,54148,54148,54593,54957,55702,57693,59348,59664,60055,60289,61278,62219,62470,63618,64025,65233,66944,69594,72189,72326,73396,74386,75678,78731,79151,79798,80091,80195,81816,84397,85030,86810,87299,88067,88382,89516,90151,92060,92355,92445,92825,93909,94796,94847,95477,96950,98761,99692,99782))
        );
    }

}
