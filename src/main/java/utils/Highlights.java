package utils;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import utils.Mark;
/*
 * 
MIT License

Copyright (c) 2019 w0rthy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 *
 */

final public class Highlights {
   // private volatile int[] Highlights;

    //private volatile HashMap<Integer, Color> Highlights;

    private volatile ArrayList<Mark> Highlights;

    private volatile int maxIndexMarked;    // The Highlights array is huge and slows down the visualizer if all its indices are read.
                                            // In an attempt to speed up the containsPosition() method while also giving anyone room
                                            // to use the full array, this variable keeps track of the farthest index an array position
                                            // has been highlighted at. The containsPosition() method only scans the Highlights array
                                            // up to index maxIndexMarked.

                                            // If an index is used in markArray() that is higher than maxPossibleMarked, the variable
                                            // is updated. If the highest index used in Highlights is removed with clearMark(), the
                                            // next biggest index (less than what was removed) is found and updates maxIndexMarked.

                                            // Trivially, clearAllMarks() resets maxIndexMarked to zero. This variable also serves
                                            // as a subtle design hint for anyone who wants to add an algorithm to the app to highlight
                                            // array positions at low indices which are close together.

                                            // This way, the program runs more efficiently, and looks pretty. :)

    private volatile int markCount;

    private boolean FANCYFINISH;
    private boolean marksEnabled;
    private boolean AdditionalMarksEnabled;
    private volatile boolean fancyFinish;
    private volatile int trackFinish;

    public Highlights(int maximumLength) {
        //this.Highlights = new int[maximumLength];
        this.Highlights = new ArrayList<>(maximumLength);
        this.FANCYFINISH = true;
        this.marksEnabled = true;
        this.AdditionalMarksEnabled = false;
        this.maxIndexMarked = 0;
        this.markCount = 0;

        //Arrays.fill(Highlights, -1);
        //Collections.fill(Highlights, new Mark(-1));
        for(int i = 0; i < maximumLength;++i){
           Highlights.add(new Mark(-1));
        }
    }

    public void setMarksEnabled(boolean value){
        this.marksEnabled = value;
    }

    public boolean getMarksEnabled(){
        return this.marksEnabled;
    }

    public void setAdditionalMarksEnabled(boolean value){
        this.AdditionalMarksEnabled = value;
    }

    public boolean getAdditionalMarksEnabled(){
        return this.AdditionalMarksEnabled;
    }

    public boolean fancyFinishEnabled() {
        return this.FANCYFINISH;
    }
    public void toggleFancyFinishes(boolean Bool) {
        this.FANCYFINISH = Bool;
    }

    public boolean fancyFinishActive() {
        return this.fancyFinish;
    }
    public void toggleFancyFinish(boolean Bool) {
        this.fancyFinish = Bool;
    }

    public int getFancyFinishPosition() {
        return this.trackFinish;
    }
    public void incrementFancyFinishPosition() {
        this.trackFinish++;
    }
    public void resetFancyFinish() {
        this.trackFinish = -1; // Magic number that clears the green sweep animation
    }

    public int getMaxIndex() {
        return this.maxIndexMarked;
    }
    public int getMarkCount() {
        return this.markCount;
    }

    //Consider revising highlightList().
    //public int[] highlightList() {
    public ArrayList<Mark> highlightList() {
        return this.Highlights;
    }
    public boolean containsPosition(int arrayPosition) {
        for(int i = 0; i <= this.maxIndexMarked; i++) {
            if(Highlights.get(i).getPosition() == -1) {
                continue;
            }
            else if(Highlights.get(i).getPosition() == arrayPosition) {
                return true;
            }
        }

        return false;
    }
    public void markArray(int marker, int markPosition) {
        if(this.marksEnabled){
            try {
                if(markPosition < 0) {
                    if(markPosition == -1) throw new Exception("Highlights.markArray(): Invalid position! -1 is reserved for the clearMark method.");
                    else if(markPosition == -5) throw new Exception("Highlights.markArray(): Invalid position! -5 was the constant originally used to unmark numbers in the array. Instead, use the clearMark method.");
                    else throw new Exception("Highlights.markArray(): Invalid position!");
                }
                else {
                    //Highlights[marker] = markPosition;

                    //Highlights.get(marker).setPosition(markPosition);
                    //Highlights.set(marker, new Mark(markPosition, Highlights.get(marker).getColor()));
                    this.setMarkPosition(marker, markPosition);
                    this.markCount++;

                    if(marker > this.maxIndexMarked) {
                        this.maxIndexMarked = marker;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clearMark(int marker) {
        //Highlights[marker] = -1; // -1 is used as the magic number to unmark a position in the main array
        //Highlights.set(marker, new Mark(-1, Highlights.get(marker).getColor()));
        this.setMarkPosition(marker, -1);
        this.markCount--;

        if(marker == this.maxIndexMarked) {
            this.maxIndexMarked = 0;

            for(int i = marker - 1; i >= 0; i--) {
                //if(Highlights[i] != -1) {
                if(Highlights.get(i).getPosition() != -1) {
                    this.maxIndexMarked = i;
                    break;
                }
            }
        }
    }
    public void clearAllMarks() {
        //Arrays.fill(this.Highlights, -1);
        Collections.fill(Highlights, new Mark(-1));
        this.maxIndexMarked = 0;
        this.markCount = 0;
    }

    public Mark getMark(int index){
        return this.Highlights.get(index);
    }

    public void setMark(int index, int position, Color color){
        this.Highlights.set(index, new Mark(position, color));
    }

    public void setMarkPosition(int index, int position){
        this.setMark(index, position, this.getMark(index).getColor());
    }

    public void setMarkColor(int index, Color color){
        this.setMark(index, this.getMark(index).getPosition(), color);
    }
}