(function() {
  'use strict';

  var ct,
    st,
    ctMin,
    ctHour,
    ctMinPct,
    ctHourMinPct,
    stMin,
    stHour,
    stMinPct,
    stHourMinPct,
    tdHourPct,
    tdMinPct,
    tdMin,
    tdHour,
    td;

  function timeDiff(crime, student) {
    ct = crime; // Variable assignment
    st = student; // Variable assignment
    ctMin = ct % 100; // Divide time by 100. Returns remainder to get minutes
    ctHour = (ct - ctMin) / 100; // Subtract minutes from time. Returns hours. Divide by 100 for hours only
    ctMinPct = ctMin / 60; // Divide minutes by 60 to get percetage of hour (eg. 30min / 60 = 0.5)
    ctHourMinPct = ctHour + ctMinPct; // Time of crime in hours, base 10
    stMin = st % 100;
    stHour = (st - stMin) / 100;
    stMinPct = stMin / 60;
    stHourMinPct = stHour + stMinPct; // Time of student in hours, base 10
    tdHourPct = ctHourMinPct - stHourMinPct; // Time difference in hours, base 10
    tdMinPct = Math.round(tdHourPct * 60); // Time difference in minutes. Math.round() to account for floating-point rounding errors. round() in Java. See this question for more info: http://programmers.stackexchange.com/questions/101163/what-causes-floating-point-rounding-errors
    tdHour = Math.floor(tdHourPct); // Math.floor() returns integer less than or equal to number (round down). floor() in Java.
    tdMin = (tdHourPct - tdHour) * 60; // Time difference (minutes only)
    td = (tdHour * 100) + tdMin; // Time difference

    return Math.round(td); // Return time difference in hhmm format.
  }

  var ctime = 1640;
  var stime = 1456;
  console.log(ctime + ' time of crime');
  console.log(stime + ' time of student');
  console.log(timeDiff(ctime, stime) + ' time elapsed, [hhm]m');
  console.log(tdMinPct + ' time elapsed, minutes');

}());

// Also at http://codepen.io/jsejcksn/pen/ZbOepX?editors=001
