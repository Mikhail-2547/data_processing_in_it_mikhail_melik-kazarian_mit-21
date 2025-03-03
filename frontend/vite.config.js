import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  build: {
    outDir: 'dist',
    emptyOutDir: true
  },
  base: '/dp-lab_2/',
  server: {
    proxy: {
      '/gadgets': {
        target: 'http://localhost:8080/dp-lab_2/',
        changeOrigin: true,
        secure: false
      }
    }
  }
})
