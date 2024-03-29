package org.polytech.project.balladeapp5.DXFParser;

import org.polytech.project.balladeapp5.Vector3;

import java.util.HashMap;

/**
 * Created by Aurelien on 24/06/13.
 */
// base de couleur prise ici : http://sub-atomic.com/~moses/acadcolors.html

public class ColorAutocad {

    public ColorAutocad() {

    }

    static public HashMap<Integer, Vector3> AutoCADcolors = new HashMap<Integer, Vector3>();
    static
    {
        AutoCADcolors.put(0,new Vector3(0,0,0));
        AutoCADcolors.put(1,new Vector3(255,0,0));
        AutoCADcolors.put(2,new Vector3(255,255,0));
        AutoCADcolors.put(3,new Vector3(0,255,0));
        AutoCADcolors.put(4,new Vector3(0,255,255));
        AutoCADcolors.put(5,new Vector3(0,0,255));
        AutoCADcolors.put(6,new Vector3(255,0,255));
        AutoCADcolors.put(7,new Vector3(255,255,255));
        AutoCADcolors.put(8,new Vector3(65,65,65));
        AutoCADcolors.put(9,new Vector3(128,128,128));
        AutoCADcolors.put(10,new Vector3(255,0,0));
        AutoCADcolors.put(11,new Vector3(255,170,170));
        AutoCADcolors.put(12,new Vector3(189,0,0));
        AutoCADcolors.put(13,new Vector3(189,126,126));
        AutoCADcolors.put(14,new Vector3(129,0,0));
        AutoCADcolors.put(15,new Vector3(129,86,86));
        AutoCADcolors.put(16,new Vector3(104,0,0));
        AutoCADcolors.put(17,new Vector3(104,69,69));
        AutoCADcolors.put(18,new Vector3(79,0,0));
        AutoCADcolors.put(19,new Vector3(79,53,53));
        AutoCADcolors.put(20,new Vector3(255,63,0));
        AutoCADcolors.put(21,new Vector3(255,191,170));
        AutoCADcolors.put(22,new Vector3(189,46,0));
        AutoCADcolors.put(23,new Vector3(189,141,126));
        AutoCADcolors.put(24,new Vector3(129,31,0));
        AutoCADcolors.put(25,new Vector3(129,96,86));
        AutoCADcolors.put(26,new Vector3(104,25,0));
        AutoCADcolors.put(27,new Vector3(104,78,69));
        AutoCADcolors.put(28,new Vector3(79,19,0));
        AutoCADcolors.put(29,new Vector3(79,59,53));
        AutoCADcolors.put(30,new Vector3(255,127,0));
        AutoCADcolors.put(31,new Vector3(255,212,170));
        AutoCADcolors.put(32,new Vector3(189,94,0));
        AutoCADcolors.put(33,new Vector3(189,157,126));
        AutoCADcolors.put(34,new Vector3(129,64,0));
        AutoCADcolors.put(35,new Vector3(129,107,86));
        AutoCADcolors.put(36,new Vector3(104,52,0));
        AutoCADcolors.put(37,new Vector3(104,86,69));
        AutoCADcolors.put(38,new Vector3(79,39,0));
        AutoCADcolors.put(39,new Vector3(79,66,53));
        AutoCADcolors.put(40,new Vector3(255,191,0));
        AutoCADcolors.put(41,new Vector3(255,234,170));
        AutoCADcolors.put(42,new Vector3(189,141,0));
        AutoCADcolors.put(43,new Vector3(189,173,126));
        AutoCADcolors.put(44,new Vector3(129,96,0));
        AutoCADcolors.put(45,new Vector3(129,118,86));
        AutoCADcolors.put(46,new Vector3(104,95,0));
        AutoCADcolors.put(47,new Vector3(104,95,69));
        AutoCADcolors.put(48,new Vector3(79,59,0));
        AutoCADcolors.put(49,new Vector3(79,73,53));
        AutoCADcolors.put(50,new Vector3(255,255,0));
        AutoCADcolors.put(51,new Vector3(255,255,170));
        AutoCADcolors.put(52,new Vector3(189,189,0));
        AutoCADcolors.put(53,new Vector3(189,189,126));
        AutoCADcolors.put(54,new Vector3(129,129,0));
        AutoCADcolors.put(55,new Vector3(129,129,86));
        AutoCADcolors.put(56,new Vector3(104,104,0));
        AutoCADcolors.put(57,new Vector3(104,104,69));
        AutoCADcolors.put(58,new Vector3(79,79,0));
        AutoCADcolors.put(59,new Vector3(79,79,53));
        AutoCADcolors.put(60,new Vector3(191,255,0));
        AutoCADcolors.put(61,new Vector3(234,255,170));
        AutoCADcolors.put(62,new Vector3(141,189,0));
        AutoCADcolors.put(63,new Vector3(173,189,126));
        AutoCADcolors.put(64,new Vector3(96,129,0));
        AutoCADcolors.put(65,new Vector3(118,129,86));
        AutoCADcolors.put(66,new Vector3(78,104,0));
        AutoCADcolors.put(67,new Vector3(95,104,69));
        AutoCADcolors.put(68,new Vector3(59,79,0));
        AutoCADcolors.put(69,new Vector3(73,79,53));
        AutoCADcolors.put(70,new Vector3(127,255,0));
        AutoCADcolors.put(71,new Vector3(212,255,170));
        AutoCADcolors.put(72,new Vector3(94,189,0));
        AutoCADcolors.put(73,new Vector3(157,189,126));
        AutoCADcolors.put(74,new Vector3(64,129,0));
        AutoCADcolors.put(75,new Vector3(107,129,86));
        AutoCADcolors.put(76,new Vector3(52,104,0));
        AutoCADcolors.put(77,new Vector3(86,104,69));
        AutoCADcolors.put(78,new Vector3(39,79,0));
        AutoCADcolors.put(79,new Vector3(66,79,53));
        AutoCADcolors.put(80,new Vector3(63,255,0));
        AutoCADcolors.put(81,new Vector3(191,255,170));
        AutoCADcolors.put(82,new Vector3(46,189,0));
        AutoCADcolors.put(83,new Vector3(141,189,126));
        AutoCADcolors.put(84,new Vector3(31,129,0));
        AutoCADcolors.put(85,new Vector3(96,129,86));
        AutoCADcolors.put(86,new Vector3(25,104,0));
        AutoCADcolors.put(87,new Vector3(78,104,69));
        AutoCADcolors.put(88,new Vector3(19,79,0));
        AutoCADcolors.put(89,new Vector3(59,79,53));
        AutoCADcolors.put(90,new Vector3(0,255,0));
        AutoCADcolors.put(91,new Vector3(170,255,170));
        AutoCADcolors.put(92,new Vector3(0,189,0));
        AutoCADcolors.put(93,new Vector3(126,189,126));
        AutoCADcolors.put(94,new Vector3(0,129,0));
        AutoCADcolors.put(95,new Vector3(86,129,86));
        AutoCADcolors.put(96,new Vector3(0,104,0));
        AutoCADcolors.put(97,new Vector3(69,104,69));
        AutoCADcolors.put(98,new Vector3(0,79,0));
        AutoCADcolors.put(99,new Vector3(53,79,53));
        AutoCADcolors.put(100,new Vector3(0,255,63));
        AutoCADcolors.put(101,new Vector3(126,255,191));
        AutoCADcolors.put(102,new Vector3(0,189,46));
        AutoCADcolors.put(103,new Vector3(126,189,141));
        AutoCADcolors.put(104,new Vector3(0,129,31));
        AutoCADcolors.put(105,new Vector3(86,129,96));
        AutoCADcolors.put(106,new Vector3(0,104,25));
        AutoCADcolors.put(107,new Vector3(69,105,78));
        AutoCADcolors.put(108,new Vector3(0,79,19));
        AutoCADcolors.put(109,new Vector3(53,79,59));
        AutoCADcolors.put(110,new Vector3(0,255,127));
        AutoCADcolors.put(111,new Vector3(170,255,212));
        AutoCADcolors.put(112,new Vector3(0,189,94));
        AutoCADcolors.put(113,new Vector3(126,189,157));
        AutoCADcolors.put(114,new Vector3(0,129,64));
        AutoCADcolors.put(115,new Vector3(86,129,107));
        AutoCADcolors.put(116,new Vector3(0,104,52));
        AutoCADcolors.put(117,new Vector3(0,104,86));
        AutoCADcolors.put(118,new Vector3(0,79,39));
        AutoCADcolors.put(119,new Vector3(53,79,66));
        AutoCADcolors.put(120,new Vector3(0,255,191));
        AutoCADcolors.put(121,new Vector3(170,255,234));
        AutoCADcolors.put(122,new Vector3(0,189,141));
        AutoCADcolors.put(123,new Vector3(126,189,173));
        AutoCADcolors.put(124,new Vector3(0,129,96));
        AutoCADcolors.put(125,new Vector3(86,129,118));
        AutoCADcolors.put(126,new Vector3(0,104,78));
        AutoCADcolors.put(127,new Vector3(69,104,95));
        AutoCADcolors.put(128,new Vector3(0,79,59));
        AutoCADcolors.put(129,new Vector3(53,79,73));
        AutoCADcolors.put(130,new Vector3(0,255,255));
        AutoCADcolors.put(131,new Vector3(170,255,255));
        AutoCADcolors.put(132,new Vector3(0,189,189));
        AutoCADcolors.put(133,new Vector3(126,189,189));
        AutoCADcolors.put(134,new Vector3(0,129,129));
        AutoCADcolors.put(135,new Vector3(86,129,129));
        AutoCADcolors.put(136,new Vector3(0,104,104));
        AutoCADcolors.put(137,new Vector3(69,104,104));
        AutoCADcolors.put(138,new Vector3(0,79,79));
        AutoCADcolors.put(139,new Vector3(53,79,79));
        AutoCADcolors.put(140,new Vector3(0,191,255));
        AutoCADcolors.put(141,new Vector3(170,234,255));
        AutoCADcolors.put(142,new Vector3(0,141,189));
        AutoCADcolors.put(143,new Vector3(126,173,189));
        AutoCADcolors.put(144,new Vector3(0,96,129));
        AutoCADcolors.put(145,new Vector3(86,118,129));
        AutoCADcolors.put(146,new Vector3(0,78,104));
        AutoCADcolors.put(147,new Vector3(69,95,104));
        AutoCADcolors.put(148,new Vector3(0,59,79));
        AutoCADcolors.put(149,new Vector3(53,73,79));
        AutoCADcolors.put(150,new Vector3(0,127,255));
        AutoCADcolors.put(151,new Vector3(170,212,255));
        AutoCADcolors.put(152,new Vector3(0,94,189));
        AutoCADcolors.put(153,new Vector3(126,157,189));
        AutoCADcolors.put(154,new Vector3(0,64,129));
        AutoCADcolors.put(155,new Vector3(86,107,129));
        AutoCADcolors.put(156,new Vector3(0,52,104));
        AutoCADcolors.put(157,new Vector3(69,86,104));
        AutoCADcolors.put(158,new Vector3(0,39,79));
        AutoCADcolors.put(159,new Vector3(53,66,79));
        AutoCADcolors.put(160,new Vector3(0,63,255));
        AutoCADcolors.put(161,new Vector3(170,191,255));
        AutoCADcolors.put(162,new Vector3(0,46,189));
        AutoCADcolors.put(163,new Vector3(126,141,189));
        AutoCADcolors.put(164,new Vector3(0,31,129));
        AutoCADcolors.put(165,new Vector3(86,96,129));
        AutoCADcolors.put(166,new Vector3(0,25,104));
        AutoCADcolors.put(167,new Vector3(69,78,104));
        AutoCADcolors.put(168,new Vector3(0,19,79));
        AutoCADcolors.put(169,new Vector3(53,59,79));
        AutoCADcolors.put(170,new Vector3(0,0,255));
        AutoCADcolors.put(171,new Vector3(170,170,255));
        AutoCADcolors.put(172,new Vector3(0,0,189));
        AutoCADcolors.put(173,new Vector3(126,126,189));
        AutoCADcolors.put(174,new Vector3(0,0,129));
        AutoCADcolors.put(175,new Vector3(86,86,129));
        AutoCADcolors.put(176,new Vector3(0,0,104));
        AutoCADcolors.put(177,new Vector3(69,69,104));
        AutoCADcolors.put(178,new Vector3(0,0,79));
        AutoCADcolors.put(179,new Vector3(53,53,79));
        AutoCADcolors.put(180,new Vector3(63,0,255));
        AutoCADcolors.put(181,new Vector3(191,170,255));
        AutoCADcolors.put(182,new Vector3(46,0,189));
        AutoCADcolors.put(183,new Vector3(141,126,189));
        AutoCADcolors.put(184,new Vector3(31,0,129));
        AutoCADcolors.put(185,new Vector3(96,86,129));
        AutoCADcolors.put(186,new Vector3(25,0,104));
        AutoCADcolors.put(187,new Vector3(78,69,104));
        AutoCADcolors.put(188,new Vector3(19,0,79));
        AutoCADcolors.put(189,new Vector3(59,53,79));
        AutoCADcolors.put(190,new Vector3(127,0,255));
        AutoCADcolors.put(191,new Vector3(212,170,255));
        AutoCADcolors.put(192,new Vector3(94,0,189));
        AutoCADcolors.put(193,new Vector3(157,126,189));
        AutoCADcolors.put(194,new Vector3(64,0,129));
        AutoCADcolors.put(195,new Vector3(107,86,129));
        AutoCADcolors.put(196,new Vector3(52,0,104));
        AutoCADcolors.put(197,new Vector3(86,69,104));
        AutoCADcolors.put(198,new Vector3(39,0,79));
        AutoCADcolors.put(199,new Vector3(66,53,79));
        AutoCADcolors.put(200,new Vector3(191,0,255));
        AutoCADcolors.put(201,new Vector3(234,170,255));
        AutoCADcolors.put(202,new Vector3(141,0,189));
        AutoCADcolors.put(203,new Vector3(173,126,189));
        AutoCADcolors.put(204,new Vector3(96,0,129));
        AutoCADcolors.put(205,new Vector3(118,86,129));
        AutoCADcolors.put(206,new Vector3(78,0,104));
        AutoCADcolors.put(207,new Vector3(95,69,104));
        AutoCADcolors.put(208,new Vector3(59,0,79));
        AutoCADcolors.put(209,new Vector3(73,53,79));
        AutoCADcolors.put(210,new Vector3(255,0,255));
        AutoCADcolors.put(211,new Vector3(255,170,255));
        AutoCADcolors.put(212,new Vector3(189,0,189));
        AutoCADcolors.put(213,new Vector3(189,126,189));
        AutoCADcolors.put(214,new Vector3(129,0,129));
        AutoCADcolors.put(215,new Vector3(129,86,129));
        AutoCADcolors.put(216,new Vector3(104,0,104));
        AutoCADcolors.put(217,new Vector3(104,69,104));
        AutoCADcolors.put(218,new Vector3(79,0,79));
        AutoCADcolors.put(219,new Vector3(79,53,79));
        AutoCADcolors.put(220,new Vector3(255,0,191));
        AutoCADcolors.put(221,new Vector3(255,170,234));
        AutoCADcolors.put(222,new Vector3(189,0,141));
        AutoCADcolors.put(223,new Vector3(189,126,173));
        AutoCADcolors.put(224,new Vector3(129,0,96));
        AutoCADcolors.put(225,new Vector3(129,86,118));
        AutoCADcolors.put(226,new Vector3(104,0,78));
        AutoCADcolors.put(227,new Vector3(104,69,95));
        AutoCADcolors.put(228,new Vector3(79,0,59));
        AutoCADcolors.put(229,new Vector3(79,53,73));
        AutoCADcolors.put(230,new Vector3(255,0,127));
        AutoCADcolors.put(231,new Vector3(255,170,212));
        AutoCADcolors.put(232,new Vector3(189,0,94));
        AutoCADcolors.put(233,new Vector3(189,126,157));
        AutoCADcolors.put(234,new Vector3(129,0,64));
        AutoCADcolors.put(235,new Vector3(129,86,107));
        AutoCADcolors.put(236,new Vector3(104,0,52));
        AutoCADcolors.put(237,new Vector3(104,69,86));
        AutoCADcolors.put(238,new Vector3(79,0,39));
        AutoCADcolors.put(239,new Vector3(79,53,66));
        AutoCADcolors.put(240,new Vector3(255,0,63));
        AutoCADcolors.put(241,new Vector3(255,170,191));
        AutoCADcolors.put(242,new Vector3(189,0,46));
        AutoCADcolors.put(243,new Vector3(189,126,141));
        AutoCADcolors.put(244,new Vector3(129,0,31));
        AutoCADcolors.put(245,new Vector3(129,86,96));
        AutoCADcolors.put(246,new Vector3(104,0,25));
        AutoCADcolors.put(247,new Vector3(104,69,78));
        AutoCADcolors.put(248,new Vector3(79,0,19));
        AutoCADcolors.put(249,new Vector3(79,53,59));
        AutoCADcolors.put(250,new Vector3(51,51,51));
        AutoCADcolors.put(251,new Vector3(80,80,80));
        AutoCADcolors.put(252,new Vector3(105,105,105));
        AutoCADcolors.put(253,new Vector3(130,130,130));
        AutoCADcolors.put(254,new Vector3(190,190,190));
        AutoCADcolors.put(255,new Vector3(255,255,255));

    }
}
