module.exports = {
  entry: {
    'react-window': './main.js'
  },
  output: {
    filename: '[name].inc.js'
  },
  externals: {
    'react': 'React',
    'react-dom': 'ReactDOM'
  }
};
