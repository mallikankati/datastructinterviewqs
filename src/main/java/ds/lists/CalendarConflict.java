package ds.lists;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CalendarConflict {
	//
	// Expression: (isPrime AND hasWonOscar) OR (releaseDate > 2007)
	//
	// OR
	// AND >
	// isPrime hasWonOscar releaseDate 2007
	// LevelOrder traversal
	// PreOrder | InOrder

	//
	// 'Find conflicts in a calendar'
	//
	// Gregrian Calendar
	// Specific to events which has start & end time
	// Are we looking in a given day | month | year
	// Given a month conflict resolution
	// start & end times are long
	// UTC from 1970
	// What is input look like list| array of (start, end)
	// Input format can be
	// Meeting calendar contains overlapping meetings
	//
	//
	public static class Meeting {
		Long start;
		Long end;
	}

	// 8 to 9
	// 9 to 10
	// 10 to 11
	// 9 to 12
	// This is a O(nlogn) solution but interviewer expected O(logn) solution
	public Set<Meeting> conflicts(List<Meeting> schedules) {
		// Sort by start time
		// prev and current is our tracking pointers
		// compare prev endtime with current start time
		// If current start time less than prev endtime there is a conflict
		if (schedules == null || schedules.isEmpty()) {
			return null;
		}
		// Sort using comparator
		schedules.sort(new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o2.start.compareTo(o1.start);
			}
		});
		Meeting prevMaxEnd = null;
		Set<Meeting> results = new LinkedHashSet<>();
		for (Meeting current : schedules) {
			if (prevMaxEnd != null) {
				if (current.start < prevMaxEnd.end) {
					results.add(prevMaxEnd);
					results.add(current);
				}
			} else {
				// In case if one meeting conflicts with multiple meetings
				/*
				 * if (!results.isEmtpy()){ for (Meeting temp : results){ if
				 * (current.start < temp.end){ results.add(current); break; } }
				 * }
				 */
			}
			if (prevMaxEnd != null) {
				if (current.end >= prevMaxEnd.end) {
					prevMaxEnd = current;
				}
			} else {
				prevMaxEnd = current;
			}
		}

		return results;
	}

}
