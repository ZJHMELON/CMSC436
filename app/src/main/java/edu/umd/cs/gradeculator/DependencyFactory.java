package edu.umd.cs.gpa;

import android.content.Context;

import edu.umd.cs.gpa.service.CourseService;
import edu.umd.cs.gpa.service.impl.InMemoryCourseService;

/**
 * Created by howardksw1 on 4/5/17.
 */

public class DependencyFactory {
    private static CourseService courseService;

    public static CourseService getCourseService(Context context) {
        if (courseService == null) {
            courseService = new InMemoryCourseService(context);
        }
        return courseService;
    }
}
