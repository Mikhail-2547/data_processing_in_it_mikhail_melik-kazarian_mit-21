import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  base: '/gadget-info',
  server: {
    proxy: {
      '/gadgets': {
        target: 'http://localhost:8080/gadget-info/',
        changeOrigin: true,
        secure: false
      }
    }
  }
})
