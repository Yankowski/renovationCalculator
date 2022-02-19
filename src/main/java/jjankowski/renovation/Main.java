package jjankowski.renovation;

import jjankowski.renovation.data.RoomsFromResourceFileProvider;
import jjankowski.renovation.data.IRoomsProvider;
import jjankowski.renovation.vo.Summary;
import jjankowski.renovation.service.SummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final String FILE = "input1.txt";

    public static void main(String[] args) {
        IRoomsProvider roomsProvider = new RoomsFromResourceFileProvider(FILE);
        Summary summary = SummaryService.createSummary(roomsProvider.load());
        LOGGER.info(summary.toString());
    }
}
