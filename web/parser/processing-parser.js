var antlr4 = require('antlr4/index');
var lexer = require('ProcessingLexer');
var parser = require('ProcessingParser');

var MyErrorListener = function(callback) {
    antlr4.error.ErrorListener.call(this);
    this.callback = callback;
    return this;
};
MyErrorListener.prototype = Object.create(antlr4.error.ErrorListener.prototype);
MyErrorListener.prototype.constructor = MyErrorListener;
MyErrorListener.prototype.syntaxError = function(recognizer, offendingToken, line, column, msg, e) {
  var start = offendingToken.start;
  var stop = offendingToken.stop;
  var len;
  if (start >= 0 && stop >= 0) {
    len = stop - start + 1;
  } else {
    len = 0;
  }
  // todo: construct better error message
  this.callback(line, column, len, msg);
};

function parseProcessing(text, callback) {
  var l = new lexer.ProcessingLexer(new antlr4.InputStream(text));
  var p = new parser.ProcessingParser(new antlr4.CommonTokenStream(l));
  p.removeErrorListeners();
  p.addErrorListener(new MyErrorListener(callback));
  p.program();
}
