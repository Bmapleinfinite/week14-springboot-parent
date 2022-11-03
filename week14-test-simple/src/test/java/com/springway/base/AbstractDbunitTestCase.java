package com.springway.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.xml.sax.InputSource;

public class AbstractDbunitTestCase {
    private File tempFile;
    
    private DatabaseConnection databaseConnection;

    private InputStream testDataIn;

    public AbstractDbunitTestCase(Connection connection, InputStream testDataIn) throws Exception {
        this.databaseConnection = new DatabaseConnection(connection);
        this.databaseConnection.getConfig().setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
        this.testDataIn = testDataIn;
    }

    public void backManyTables(String... tableName) throws Exception {
        QueryDataSet queryDataSet = new QueryDataSet(databaseConnection);
        for (String string : tableName) {
            queryDataSet.addTable(string);
        }
        tempFile = File.createTempFile("back", ".xml");
        FlatXmlDataSet.write(queryDataSet, new FileOutputStream(tempFile));
    }

    public void backOneTable(String tableName) throws Exception {
        backManyTables(tableName);
    }

    public void insertTestData() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(tempFile))));
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);
    }

    public void rollBackTable() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(testDataIn)));
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);
    }
}
