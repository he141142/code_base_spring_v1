package com.sykros.codebase.utils.module.console.wagu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaguExtension implements IWagu {

    List<String> headers;
    List<List<String>> rows;

    public WaguExtension() {
        this.rows = new ArrayList<>();
    }

    @Override
    public String getTableFormat() {
        Board board = new Board(75);
        return board.
                setInitialBlock(new WaguTable(board,
                        75, this.headers, this.rows).
                        tableToBlocks()).
                build().
                getPreview();
    }

    public WaguExtension WithHeaders(String... headers) {
        this.headers = Arrays.asList(headers);
        return this;
    }

    public WaguExtension AddRow(String... rows) {
        this.rows.add(Arrays.asList(rows));
        return this;
    }


}
