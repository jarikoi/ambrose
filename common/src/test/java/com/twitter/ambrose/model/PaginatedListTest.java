package com.twitter.ambrose.model;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.*;

import com.google.common.collect.Maps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by jkoister on 3/25/14.
 */
public class PaginatedListTest {


    private void testPaginatedList(PaginatedList expected) throws IOException {
        assertNotNull(expected);
        assertNotNull(expected.getResults());
        assertNotNull(expected.getNextPageStart());
    }

    @Test
    public void testPaginatedList() throws IOException {
        Properties properties = new Properties();
       //  final PaginatedList<WorkflowSummary> summaries =
       //         new PaginatedList<WorkflowSummary>(ImmutableList.of(summary));
        List<WorkflowSummary> summaries1 = new ArrayList<WorkflowSummary>();
        summaries1.add(new WorkflowSummary("id1", "uid1","name1",WorkflowSummary.Status.RUNNING,10, System.currentTimeMillis())
        );
        summaries1.add(new WorkflowSummary("id2", "uid2","name2",WorkflowSummary.Status.RUNNING,20, System.currentTimeMillis())
        );
        ImmutableList<WorkflowSummary> summaries  = ImmutableList.copyOf(summaries1);
        PaginatedList pl = new PaginatedList<WorkflowSummary>(summaries);
        pl.setNextPageStart(("SomeKey"));
        testPaginatedList(pl);
    }
}
