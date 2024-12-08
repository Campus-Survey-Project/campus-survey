
export default {
  bootstrap: () => import('./main.server.mjs').then(m => m.default),
  inlineCriticalCss: true,
  routes: [
  {
    "renderMode": 2,
    "route": "/"
  }
],
  assets: new Map([
['index.csr.html', {size: 4914, hash: 'd5e1892cadf65f3fcd51c1c7251e367f16a9b191c00cb92b7603ab520d9ee2b9', text: () => import('./assets-chunks/index_csr_html.mjs').then(m => m.default)}], 
['index.server.html', {size: 1013, hash: 'a5763b31bd0bc58f8568835f009d29d4f8a01d0e597cefac90f978efd00174bc', text: () => import('./assets-chunks/index_server_html.mjs').then(m => m.default)}], 
['index.html', {size: 10302, hash: '5700561f77c2c1371c88b5e6b64abf7b0219c6e4a87d008e8d2bad27ecfcbe0e', text: () => import('./assets-chunks/index_html.mjs').then(m => m.default)}], 
['styles-DZ6UBGXD.css', {size: 231612, hash: 'B2Fy9V+bfZo', text: () => import('./assets-chunks/styles-DZ6UBGXD_css.mjs').then(m => m.default)}]
]),
  locale: undefined,
};
