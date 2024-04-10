module.exports = {
  devServer: {
    proxy: {
      '/api': { // /api 주소로 이동하게 되면 아래 주소로 우회해서 이동한다.
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
}