'use strict'



module.exports = {
    dev: {
  
      // Paths
      assetsSubDirectory: 'static',
      assetsPublicPath: '/',
      proxyTable: {
        '/admin-api': {
          target: 'http://localhost:28080',
          changeOrigin: true,
          pathRewrite: {
            '^/admin-api': ''
          }
        },
        
      },
      
    }
}