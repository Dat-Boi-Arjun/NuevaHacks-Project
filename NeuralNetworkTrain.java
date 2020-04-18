package com.arjun.projects.boredomanalysis;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.transform.TransformProcess;
import org.datavec.api.transform.schema.InferredSchema;
import org.datavec.api.transform.schema.Schema;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.models.word2vec.iterator.Word2VecDataSetIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.BertWordPiecePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.io.Assert;

import java.io.File;
import java.io.IOException;

public class NeuralNetworkTrain {


  public NeuralNetworkTrain(){

  }

  public static void main(String[] args) throws IOException, InterruptedException {
    String TRAIN_DATA_PATH = "/Users/arjun/Downloads/trainingandtestdata/training.1600000.processed.noemoticon.csv";
    File trainingDataFile = new File(TRAIN_DATA_PATH);
    RecordReader rr = new CSVRecordReader(0, ',');
    rr.initialize(new FileSplit(trainingDataFile));

    int labelIndex = 0;
    int numClasses = 3;
    int batchSize = 128;

    DataSetIterator iterator = new RecordReaderDataSetIterator(rr, batchSize, labelIndex, numClasses);

    InferredSchema inferredSchema = new InferredSchema(TRAIN_DATA_PATH);
    Schema schema = inferredSchema.build();

    System.out.println("Labels: \n" + iterator.getLabels());

//    System.out.println("Before transform: \n" + schema);
//    TransformProcess tp = new TransformProcess.Builder(schema)
//        .removeColumns("ID", "Date", "Query")
//        .build();
//
//    System.out.println("After Transform: \n" + tp.getFinalSchema());
//
//    System.out.println("Iterator data: \n" + iterator.next());
//
//    tp.getFinalSchema();

    TokenizerFactory tf = new DefaultTokenizerFactory();

    tf.setTokenPreProcessor(new CommonPreprocessor());

//    Word2Vec vector = new Word2Vec.Builder()
//        .minWordFrequency(5)
//        .iterations(1)
//        .layerSize(100)
//        .seed(1234)
//        .windowSize(5)
//        .iterate(iterator)
//        .tokenizerFactory(tf)
//        .build();



  }


}
