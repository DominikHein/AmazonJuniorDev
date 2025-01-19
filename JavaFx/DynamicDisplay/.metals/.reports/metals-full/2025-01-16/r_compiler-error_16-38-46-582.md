file://<WORKSPACE>/src/main/java/org/example/App.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/src/main/java/org/example/App.java
text:
```scala
package org.example;

import java.util.Arrays;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

private String[] trainDetails = { "Train 1", "Train 2", "Train 3", "Train 4", "Train 5"/*TODO 1 intialize 5 unique train names*/ };
private int currentIndex = 0; //TODO 2 To track which train is currently displayed


    @Override
    public void start(Stage primaryStage) {
        //TODO 4 Clear all the code from the start method
        //TODO 5 A Label will act as the notice board, displaying the next arriving train.
        Label trainNoticeBoard = new Label("Next train arriving soon...");
        //TODO 6 A VBox (Vertical Box) will stack the Label vertically within the window. You’ll want to add some vertical spacing between the components.
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);    
        layout.getChildren().add(trainNoticeBoard);
        //TODO 7 Create a Scene using the VBox layout and set it on the primary Stage.
        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Train Notice Board");
        primaryStage.show();
        /* TODO 8: Use JavaFX’s Timeline or AnimationTimer to create a repeating task. This task will update the Label with the next train’s details every 5 seconds. */
        String[] trainDetails = {
            "Train 1 to City Center - Arriving in 5 minutes",
            "train 2 to Downtown - Arriving in 10 minutes",
            "Train 3 to Uptown - Arriving in 15 minutes"
        };
        /* TODO 9: In the repeating task, you’ll update the Label with the next train’s details from the array.
            After displaying the last train, cycle back to the first one.
        */
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event ->
        {
            String currentText = trainNoticeBoard.getText();
            int currentIndex = Arrays.asList(trainDetails).indexOf(currentText);
            int nextIndex = (currentIndex + 1) % trainDetails.length;
            trainNoticeBoard.setText(trainDetails[nextIndex]);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    public static void main(String[] args) {
        /* TODO 10: call the launch method */
        launch(args);
    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:373)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:117)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator